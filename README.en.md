# Khipro Android

An extremely fast and lightweight Bengali keyboard for Android. It supports phonetic typing, making it easy to type in both Bengali and English.

## Features

*   **Easy Phonetic Typing:** Simple layout similar to Avro or other phonetic keyboards.
*   **Bengali & English Modes:** Quick language switching capability.
*   **Conjunct Support:** Powerful engine to help type complex Bengali conjuncts (juktobornos) easily.
*   **Symbol Layout:** All necessary signs and numbers in one place.
*   **Fast Backspace:** Advanced backspace logic to improve typing speed.
*   **Smart Buffer Management:** Automatic buffer cleaning when input focus changes or apps switch.

## Setup Guide

Follow these steps to clone the project from GitHub and build the APK on your machine:

### 1. Prerequisites
Ensure the following software is installed on your computer:
*   **Git:** For downloading the project.
*   **Android Studio (Latest version):** For code editing and building the app.

### 2. Clone the Project
Open your computer's command prompt (CMD) or terminal, navigate to your desired directory, and run:
```bash
git clone https://github.com/joysriramsarkar/khipro_android.git
```

### 3. Open in Android Studio
*   Launch Android Studio.
*   Click **'Open'** and select the folder where you cloned the project.
*   Wait for Gradle to sync. This may take a few minutes depending on your internet speed.

### 4. Run the App
*   Connect your Android phone to the PC (USB Debugging must be enabled) or start an emulator.
*   Click the green **'Run'** button from the top menu of Android Studio.
*   Once the app is installed, enable the keyboard from the device settings.

### 5. Build APK
If you want to generate an installable APK file:
*   Go to **Build** > **Build Bundle(s) / APK(s)** > **Build APK(s)** in Android Studio.
*   A pop-up will appear after a while. Click **'locate'** to find your generated APK file.

## Development

This project is built using Android Studio and Kotlin.

### Technical Details:
*   Custom IME implementation using `InputMethodService`.
*   Phonetic mapping via `BengaliEngine`.
*   Custom keyboard layout using XML.

---

© [Khipro Team](https://khipro.khiproteam.com/)
