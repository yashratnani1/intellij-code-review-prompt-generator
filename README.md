# IntelliJ Code Review Prompt Generator

This IntelliJ IDEA plugin streamlines your code review process by automatically generating comprehensive prompts, perfect for both human and LLM-powered reviews.

## Overview

The **IntelliJ Code Review Prompt Generator** With a simple right-click, you can instantly generate a structured prompt containing:

* File names of all modified files.
* The complete content of each modified file.

This plugin is especially powerful when used in conjunction with Large Language Models (LLMs) for pre-PR code reviews, allowing for rapid feedback and improved code quality.

## Features

* **Instant Prompt Generation:** Generate review prompts with a single click.
* **Comprehensive Content:** Includes the full content of modified files for complete context.
* **LLM-Friendly:** Ideal for feeding code changes into LLMs for automated reviews.
* **Pre-PR Review Support:** Facilitates quick feedback before creating a pull request.
* **Local Review Capabilities:** Works without a remote git repository.

## Installation

1.  **Download:** Download the plugin from the [Releases](https://github.com/yashratnani1/intellij-code-review-prompt-generator/releases) page.
2.  **Install:**
    * In IntelliJ IDEA, go to `Settings` (or `Preferences` on macOS) -> `Plugins`.
    * Click the gear icon and select `Install Plugin from Disk...`.
    * Choose the downloaded plugin `.zip` file.
    * Click `OK` and restart IntelliJ IDEA.

## Usage

1.  **Open a Modified File:** Open any file that has been modified within your project.
2.  **Generate Prompt:** Right-click within the editor window and select `Generate Code Review Prompt`.
3.  **Copy Prompt:** A dialog box will appear with the generated prompt. Copy the content.
4.  **Use Prompt:**
    * Paste the prompt into your code review tool (e.g., GitHub PR, GitLab MR).
    * Paste the prompt into an LLM interface for automated code review.
    * Share it with your team via messaging platforms or email.

## Benefits

* **Accelerated Initial Feedback:** LLMs provide instant feedback, unlike human reviews that can take time.
* **Comprehensive Analysis:** LLMs analyze code for style, potential bugs, and adherence to best practices with consistency.
* **Pre-PR Validation:** Use the generated prompt to get an initial review from an LLM *before* creating a pull request.
* **Improved Code Quality:** Ensure your code meets a higher standard before it reaches your team.
* **Focused Human Reviews:** Human reviewers can focus on higher-level issues after an LLM review.
* **Contextual Clarity:** Full file content provides LLMs with necessary context.
* **Time Savings:** Automate prompt creation, freeing up time for actual review.
* **Increased Accuracy:** Ensure all changes are included, reducing oversights.

## Acknowledgements

* IntelliJ Platform SDK
