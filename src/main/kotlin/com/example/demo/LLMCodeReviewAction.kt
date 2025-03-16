package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.changes.Change
import com.intellij.openapi.vcs.changes.ChangeListManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.ui.Messages
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class LLMCodeReviewAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project: Project = e.project ?: return

        val changeListManager = ChangeListManager.getInstance(project)
        val changes: MutableCollection<Change> = changeListManager.allChanges

        val javaChanges = changes.stream()
                .filter { change: Change ->
                    val file: VirtualFile? = change.virtualFile
                    file != null && file.name.endsWith(".java")
                }
                .collect(Collectors.toList())

        if (javaChanges.isEmpty()) {
            Messages.showInfoMessage("No Java file changes found.", "LLM Code Review")
            return
        }

        val promptBuilder = StringBuilder()
        promptBuilder.append("Review the following Code Changes. Act as a senior software engineer providing a detailed code review. Focus on the following areas:\n\n")
        promptBuilder.append("Functionality:\n" +
                "Does the code achieve its intended purpose?\n" +
                "Are there any edge cases or scenarios that are not handled?\n" +
                "Are there any potential side effects or unintended consequences?\n" +
                "Code Quality:\n" +
                "Is the code readable and maintainable?\n" +
                "Are there any code smells or areas for refactoring?\n" +
                "Are coding standards and best practices followed?\n" +
                "Is the code properly commented?\n" +
                "Error Handling:\n" +
                "Are potential exceptions handled appropriately?\n" +
                "Are error messages informative and helpful?\n" +
                "Is logging used effectively?\n" +
                "Performance:\n" +
                "Are there any potential performance bottlenecks?\n" +
                "Are there any opportunities for optimization?\n" +
                "Testing:\n" +
                "Are there sufficient unit tests and integration tests?\n" +
                "Do the tests cover all critical functionality?\n" +
                "Are the tests well written?\n" +
                "Security:\n" +
                "Are there any potential security vulnerabilities?\n" +
                "Is sensitive data handled securely?\n" +
                "Dependencies:\n" +
                "Are all dependencies necessary?\n" +
                "Are the dependancies up to date?\n" +
                "Configuration:\n" +
                "Are configurations handled correctly?\n" +
                "Are there any hardcoded values that should be configurable?\n" +
                "Provide specific feedback, including:\n" +
                "\n" +
                "Line-by-line comments where applicable.\n" +
                "Suggestions for improvements.\n" +
                "Any potential bugs or issues you identify.\n" +
                "Overall assessment of the code quality.\n" +
                "Please provide the response in markdown format.\n\n")
        promptBuilder.append("Below are the files which are required to be reviewed:\n\n")
        for (change in javaChanges) {
            val file = change.virtualFile
            if (file != null) {
                promptBuilder.append("File: ").append(file.name).append("\n")
                try {
                    val fileContent = String(Files.readAllBytes(Paths.get(file.path)))
                    promptBuilder.append("```java\n").append(fileContent).append("\n```\n\n")
                } catch (ex: IOException) {
                    promptBuilder.append("Error reading file: ").append(ex.message).append("\n\n")
                }
            }
        }
        promptBuilder.append("Provide feedback on code quality, potential bugs, Runtime Exceptions, styles and areas for improvement.\n\n")
        promptBuilder.append("The summary of the output should be concise with bullet points so that it is easy to understand.\n\n")
        val prompt = promptBuilder.toString()
        copyToClipboard(prompt)
        Messages.showInfoMessage("Prompt copied to clipboard!", "LLM Code Review")
    }

    private fun copyToClipboard(text: String) {
        val stringSelection = StringSelection(text)
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(stringSelection, null)
    }
}