# Changelog

This project adheres to [Semantic Versioning](http://semver.org/).

## Scope Glossary

When appending to a changelog, the changes must be listed with a corresponding scope. A scope denotes the type of change that has occurred.

### [ADMIN]

The ADMIN scope denotes a change that affect the structure and layout of this repository. This includes updates to the following:

- CODEOWNERS
- README
- DotFiles (.gitignore, .git-attributes, etc)
- Anything that a developer working on this repo should be aware of from a standards and practice perspective

### [BUGFIX]

The BUGFIX scope denotes a change that fixes an issue with the project in question. A BUGFIX should align the behavior of the service with the current expected behavior of the service. If a BUGFIX introduces new unexpected behavior to amend the issue, a corresponding FEATURE or ENHANCEMENT scope should also be added to the changelog.

### [CHANGE]

The CHANGE scope denotes a change that alters the expected behavior of the project while not adding new functionality or fixing an underling issue. This commonly occurs when renaming things to make them more consistent or to accommodate updated dependencies' versions.

### [CICD]

The CICD scope denotes a change that affect the tooling and operations that run on this repository. For example:

- Updates to the CICD pipelines
- Fixtures added to improve testing
- Anything related to the CICD workflow of code in this repository

### [FEATURE]

The FEATURE scope denotes a change that adds new functionality to the project/service.

### [ENHANCEMENT]

The ENHANCEMENT scope denotes a change that improves upon the current functionality of the project/service. Generally, an enhancement is something that improves upon something that is already present. Either by making it simpler, more powerful or more performant. For example:

- An optimization on a particular process in a service that makes it more performant
- Simpler syntax for setting a configuration value, like allowing `1m` instead of 60 for a duration setting.


## main


# 0.0.1
- [FEATURE]: Brief description (e.g. PR title)
