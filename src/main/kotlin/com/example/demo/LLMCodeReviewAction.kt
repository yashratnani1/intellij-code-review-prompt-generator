package com.example.demo

import com.example.demo.constants.PromptConstants
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
        promptBuilder.append("Review the following Code Changes. Act as a senior software engineer providing a detailed code review:\n\n")
        promptBuilder.append(PromptConstants.promptPrefix)
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
        promptBuilder.append(PromptConstants.promptSuffix)
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