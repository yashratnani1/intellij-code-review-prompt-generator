package com.example.demo.constants

object PromptConstants {
    const val promptPrefix = "**Objective:** Conduct a thorough code review to assess adherence to coding standards, " +
            "code quality, potential runtime exceptions, and identify other potential issues.\n" +
            "\n" +
            "**Instructions:**\n" +
            "\n" +
            "1.  **Analyze the following code files:**\n"

    const val promptSuffix = "\n" +
            "    ```\n" +
            "\n Files which are required to be reviewed are structured as follows : \n" +
            "    File: [filename1]\n" +
            "    ```\n" +
            "    ```[contents of filename1 with each line including line number]```\n" +
            "\n" +
            "    ```\n" +
            "    File: [filename2]\n" +
            "    ```\n" +
            "    ```[contents of filename2 with each line including line number]```\n" +
            "\n" +
            "    ```\n" +
            "    File: [filename3]\n" +
            "    ```\n" +
            "    ```[contents of filename3 with each line including line number]```\n" +
            "\n" +
            "2.  **Provide file-specific review comments:**\n" +
            "\n" +
            "    * For each file, conduct a detailed review focusing on:\n" +
            "        * Adherence to established coding standards (e.g., PEP 8 for Python, Google Style for C++, etc.).\n" +
            "        * Code readability and maintainability.\n" +
            "        * Potential runtime exceptions and error handling.\n" +
            "        * Code quality, including efficiency, clarity, and best practices.\n" +
            "        * Potential logic errors or inconsistencies.\n" +
            "        * Security vulnerabilities.\n" +
            "        * Performance considerations.\n" +
            "        * Any other potential issues that you identify.\n" +
            "    * Be specific, providing line numbers and concrete examples.\n" +
            "    * If a file is exceptionally well-written, acknowledge it, and explain why.\n" +
            "    * If a file is poorly written, be specific about the problems and how to fix them.\n" +
            "    * If any external libraries or dependencies are used, comment on their appropriate usage.\n" +
            "    * If there are sections of code that are unclear or difficult to understand, highlight them.\n" +
            "\n" +
            "3.  **Structure your response as follows:**\n" +
            "\n" +
            "    ```\n" +
            "    **File: [filename1]**\n" +
            "\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * ...\n" +
            "    * Overall: [General assessment of the file's quality and any overarching concerns.]\n" +
            "\n" +
            "    **File: [filename2]**\n" +
            "\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * ...\n" +
            "    * Overall: [General assessment of the file's quality and any overarching concerns.]\n" +
            "\n" +
            "    **File: [filename3]**\n" +
            "\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]\n" +
            "    * ...\n" +
            "    * Overall: [General assessment of the file's quality and any overarching concerns.]\n" +
            "\n" +
            "    **Summary:**\n" +
            "\n" +
            "    * **[filename1]:** [Brief summary of the file's changes and key review points, including overall quality.]\n" +
            "    * **[filename2]:** [Brief summary of the file's changes and key review points, including overall quality.]\n" +
            "    * **[filename3]:** [Brief summary of the file's changes and key review points, including overall quality.]\n" +
            "    * ...\n" +
            "    ```\n" +
            "\n" +
            "4.  **Prioritize critical issues:** Clearly identify any critical issues that require immediate attention (e.g., potential security vulnerabilities, likely runtime exceptions).\n" +
            "\n" +
            "5.  **Maintain a constructive and professional tone:** Provide feedback that is helpful and actionable.\n" +
            "\n" +
            "6.  **If a file has no issues, write \"File: [filename] - No issues found.\"**"
}