# Developer Guide

This guide will walk you through the process of running AIgenda, a multi-module gradle application.

## Prerequisites

- JDK 17 or later installed on your machine. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or install it via a package manager like Homebrew on macOS or Chocolatey on Windows.
- Kotlin
- Gradle

## Setting up Kotlin and Gradle

### macOS

1. Install Homebrew
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

2. Install OpenJDK 17
```
brew install openjdk@17
```
3. Install Kotlin
```
brew install kotlin
```
4. Install Gradle
```
brew install gradle
```

### Windows

1. Install chocolatey
```
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```
2. Install OpenJDK 17
```
choco install openjdk17
```
3. Install Kotlin
```
choco install kotlin
```
4. Install Gradle
```
choco install gradle
```


## Running a Multi-Module Application

> **Note:** It's important to build this multi-module project from the root folder. Some of the modules are libraries that don't contain a main class, so attempting to build them individually may result in errors. Always ensure you're in the root directory of the project before running your build command.

1. Navigate to the project directory in your terminal or command prompt.
2. Build the project using Gradle:
```agsl
gradle clean build
```
This will compile your code and run any tests. If the build is successful, you should see a BUILD SUCCESSFUL message.

3. Run the application:
```agsl
gradle run
```

## Troubleshooting

If you encounter any issues, make sure your JDK, Kotlin, and Gradle installations are all correct and up to date. You can check the versions by running java -version, kotlin -version, and gradle -version, respectively.
If the problem persists open a GitHub issue or contact the community.