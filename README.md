# Task List Android App

A small Android application for creating and managing simple tasks. It provides a clean two-screen flow where users can add tasks, assign priorities, inspect task details, and remove completed items from the list.

<p>
  <img width="320" alt="Task list screen" src="https://github.com/user-attachments/assets/6c4c842f-b674-43ca-a169-93370676baf6" />
  <img width="320" alt="Task details screen" src="https://github.com/user-attachments/assets/f644c27b-5ad9-4231-8dac-b4cda1d5f5ce" />
</p>

## Overview

Task List Android App is built with Java and XML layouts. The project focuses on essential Android development concepts, including activity navigation, intent extras, form handling, list rendering, and simple state management inside an activity.

## Features

- Create a task with a title and description.
- Assign a priority level: `Basse`, `Moyenne`, or `Haute`.
- Display tasks in a dynamic `ListView`.
- Keep a live counter of total tasks.
- Open a separate details screen for each task.
- Remove a task with a long press.
- Show user feedback with Android `Toast` messages.

## Tech Stack

- Java
- Android SDK
- XML layouts
- AppCompat
- Material Components
- Gradle

## App Screens

### Task List

The main screen contains the task form, priority selector, action buttons, task counter, and list of saved tasks.

### Task Details

The details screen displays the selected task title, priority, and description.

## Project Structure

```text
app/src/main/
  java/com/example/lab04/
    MainActivity.java
    Screen2Activity.java
  res/layout/
    activity_main.xml
    activity_screen2.xml
  res/values/
    strings.xml
```

## Implementation

`MainActivity` stores tasks in an `ArrayList`, renders them with an `ArrayAdapter`, and handles the add, clear, open, and delete actions.

`Screen2Activity` receives the selected task through intent extras and presents its information on a dedicated screen.

## Build

```powershell
.\gradlew.bat assembleDebug
```
