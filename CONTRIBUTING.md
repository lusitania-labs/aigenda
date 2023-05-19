# Contributing to AIgenda

First off, thank you for considering contributing to Aigenda. It's people like you that make Aigenda such a great tool.

## Where do I go from here?

If you've noticed a bug or have a feature request, make one! 
It's generally best if you get confirmation of your bug or approval for your feature request this way before starting to code.

If you have a general question, creating an issue is fine.

## Fork & create a branch

If this is something you think you can fix, then fork Aigenda and create a branch with a descriptive name.

A good branch name would be (where issue #325 is the ticket you're working on):

```sh
git checkout -b 325-add-xyz-plugin
```

## Did you find a bug?
Ensure the bug was not already reported by searching on GitHub under Issues.

If you're unable to find an open issue addressing the problem, open a new one. Be sure to include a title and clear description, as much relevant information as possible, and a code sample or an executable test case demonstrating the expected behavior that is not occurring.

## Implement your fix or feature
At this point, you're ready to make your changes! Feel free to ask for help; everyone is a beginner at first.

## Code Style Guidelines
In our project, we're committed to maintaining a consistent and readable code style. To help achieve this, we're using the Detekt plugin for code formatting and linting.

Before opening a Pull Request, please ensure your code adheres to our style guidelines by running the Detekt Gradle task:

```bash
./gradlew detekt
```
This command will analyze your code and report any style violations. Please fix any warnings or errors reported by Detekt before opening a Pull Request.

## Testing Guidelines

Testing is a crucial part of our development process. It helps us ensure the quality of our code and prevents future changes from breaking existing logic.

When contributing to our project, please make sure to write tests for your code. These tests should cover the main functionality of your contribution and any edge cases you can anticipate.

Before opening a Pull Request, please ensure that all tests pass. You can run the tests using the following Gradle command:

```bash
./gradlew test
```

## Opening a Pull Request

Once your code is ready and all tests are passing, you can open a Pull Request (PR) to propose your changes to the main codebase.

Here's a basic guide on how to do this:

1. **Push your changes** to a new branch on your fork of the repository.

2. **Navigate to the original repository** on GitHub.

3. **Click the 'Pull requests' tab** and then click the 'New pull request' button.

4. **Choose the branch from your fork** that contains your changes, and then click the 'Create pull request' button.

5. **Fill out the PR form** according to our `pull_request_template.md`. This template provides a structure for describing your changes, including the purpose of the changes, the approach you took, and any other relevant information. Following this template helps maintainers understand your changes and makes the review process faster and more effective.

6. **Submit the PR**. Maintainers will review your changes and provide feedback. They may request changes before merging your PR into the main codebase.

Remember, a good PR includes a clear description of the changes and thorough testing. Thank you for your contributions!

## Merging a PR (maintainers only)

1. Branch was created from `main`.
2. Code that should be tested.
3. If you've changed APIs, documentation was updated.
4. Ensure the test suite passes.
5. Make sure your code lints.