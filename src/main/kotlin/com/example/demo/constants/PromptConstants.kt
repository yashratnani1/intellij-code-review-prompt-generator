package com.example.demo.constants

object PromptConstants {
    const val promptPrefix = """**Code Review Instructions**

    **Objective:** Conduct a thorough review of the provided files, focusing on code quality, adherence to standards, and potential issues.

    **Input Format:**"""

    const val promptSuffix = """Files are presented in the following structure:

    ```
    File: [filename1]
    ```
    ```
    [contents of filename1 with each line including line number]
    
    References:
    ```
    ```
    File: [filename2]
    ```
    ```
    [contents of filename2 with each line including line number]
    
    References:
    ```
    ...

    **Review Criteria:**
    * **Coding Standards:** Verify adherence to established standards (e.g., PEP 8 for Python, Google Style for C++, etc.).
    * **Readability and Maintainability:** Assess clarity, consistency, and ease of understanding.
    * **Exception Analysis:** Identify potential occurrences of the following exceptions: NullPointerException, IndexOutOfBoundsException, and any other relevant exceptions based on the code's context.
    * **Null Check Verification:** Check if every variable that can potentially be null is checked before being dereferenced. Identify cases where null checks are missing or inadequate.
    * **Data Flow Analysis:** Trace the flow of variables and data through the code to identify potential null pointer exceptions, uninitialized variables, and other data-related errors. Pay special attention to variables that are used without prior null checks.
    * **Code Quality:** Evaluate efficiency, clarity, best practices, and overall code design. Also, suggest if any design pattern can be applied.
    * **Logic Errors:** Detect inconsistencies or logical flaws.
    * **Security:** Identify potential security vulnerabilities.
    * **Performance:** Analyze performance implications and potential bottlenecks.
    * **Dependency Usage:** Evaluate the appropriate use of external libraries.
    * **Clarity:** Highlight sections that are difficult to understand.

    **Output Format:**

    ```
    **File: [filename1]**

    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * ...
    * Line [line number]: [Exception type] - [Description of the potential exception and the circumstances that could cause it.]
    * Overall: [General assessment of the file's quality and any overarching concerns.]
    
    **File: [filename2]**

    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * ...
    * Line [line number]: [Exception type] - [Description of the potential exception and the circumstances that could cause it.]
    * Overall: [General assessment of the file's quality and any overarching concerns.]

    **File: [filename3]**

    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * Line [line number]: [Specific comment regarding coding standards, potential exception, quality, etc.]
    * ...
    * Line [line number]: [Exception type] - [Description of the potential exception and the circumstances that could cause it.]
    * Overall: [General assessment of the file's quality and any overarching concerns.]

    **Summary:**

    * **[filename1]:** [Brief summary of the file's changes and key review points, including overall quality.]
    * **[filename2]:** [Brief summary of the file's changes and key review points, including overall quality.]
    * **[filename3]:** [Brief summary of the file's changes and key review points, including overall quality.]
    ...

    **Code Suggestions:**

    * **[filename1]:** [Improvised code suggestion with all review comments and **exception handling improvements** incorporated. If no issues, write "No changes required."]
    * **[filename2]:** [Improvised code suggestion with all review comments and **exception handling improvements** incorporated. If no issues, write "No changes required."]
    * **[filename3]:** [Improvised code suggestion with all review comments and **exception handling improvements** incorporated. If no issues, write "No changes required."]
    ...
    ```

    **Instructions:**

    1.  **Provide File-Specific Review Comments:**
    * For each file, conduct a detailed review based on the criteria above. focusing strictly on the code within those files. Do not make assumptions about any external code or project context.
    * Be specific, providing line numbers and concrete examples.
    * Acknowledge well-written code and explain why.
    * Clearly identify problems and suggest solutions for poorly written code.
    * Comment on the appropriate usage of external libraries or dependencies.
    * Highlight unclear or difficult-to-understand code sections.
    2.  **Prioritize Critical Issues:** Clearly identify any critical issues that require immediate attention (e.g., security vulnerabilities, runtime exceptions).
    3.  **Maintain a Constructive Tone:** Provide helpful and actionable feedback.
    4.  **No Issues:** If a file has no issues, write "File: [filename] - No issues found."
    5.  **Improvised Code Suggestions:** Following the "Summary" section, provide revised JAVA code suggestion (in a code block) for each file that had review comments. If a file had no issues, specify "No changes required." Ensure the suggested code incorporates all the review comments provided.
    6.  **Clarity and Detail:** Ensure your review is detailed and provides clear guidance for improvements.
    7.  **Consistency:** Maintain a consistent style and level of detail throughout the review.
    8.  **Context awareness:** Try to understand the context of the code, and provide suggestions that fit into the overall project.
    9.  **Incorporate Exception Handling:** Ensure all potential exceptions identified in the review are addressed in the "Code Suggestions" section. This includes adding necessary null checks, try-catch blocks, or other appropriate error handling mechanisms.
    10. **Do not speculate or provide opinions. Only report factual information based on the provided code.
    """;
}