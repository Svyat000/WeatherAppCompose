# WeatherAppCompose

A modern Android weather application built with Jetpack Compose, Kotlin, and a focus on clean architecture.

## Overview

WeatherAppCompose is a sample application that demonstrates how to build a robust and maintainable Android app using the latest technologies and best practices.  It fetches weather data from a remote API and displays it in a user-friendly interface.

## Key Technologies & Architecture

*   **Jetpack Compose:**  A modern toolkit for building native Android UI declaratively.
*   **Kotlin:** The primary programming language, leveraging its conciseness and safety features.
*   **MVVM (Model-View-ViewModel):**  A design pattern that separates the UI (View) from the data and logic (ViewModel), improving testability and maintainability.
*   **Dagger Hilt:** A dependency injection library that simplifies dependency management and provides a standardized way to inject dependencies into Android components.
*   **Retrofit:** A type-safe HTTP client for Android and Java, used for making network requests to the weather API.
*   **Kotlin Coroutines:**  A concurrency design pattern used for asynchronous operations, such as network requests, making the app responsive and avoiding blocking the main thread.
*   **MutableStateFlow:** A reactive data stream from Kotlin Coroutines used to manage and observe UI state changes.

## Features

*   **Current Weather:** Displays the current weather conditions for a selected location.
*   **Location Search:** Allows users to search for and select a location.
*   **Daily and 3-Day Forecast:** Once a location is found, the app displays two tabs: one showing the current weather conditions for the day, and another displaying a 3-day weather forecast.
*   **Clean Architecture:** Organized into layers for data, domain, and presentation, promoting separation of concerns.
*   **Error Handling:** Graceful handling of network errors and other potential issues.
*   **Loading Indicators:** Provides visual feedback to the user during data loading.

## How to Use

1.  **Open the application.**
2.  **Enter a city name:**  At the top of the screen, you'll find a text field for entering the city you want to find the weather for.
3.  **Automatic Weather Display:** After entering a city name, the app will automatically fetch and display the weather information for that location. The weather data will be shown in two tabs: the current daily weather and the 3-day forecast.
   
## Setup and Installation

1.  **Clone the repository:**

    ```bash
    git clone [your_repository_url]
    ```

2.  **Open the project in Android Studio.**

3.  **Add API Key:**  You'll need to obtain an API key from a weather data provider (e.g., OpenWeatherMap, WeatherApi).  Once you have the key, add it to your `local.properties` file:

    ```properties
    WEATHER_API_KEY="YOUR_API_KEY"
    ```

    (Make sure to add `local.properties` to your `.gitignore` file to prevent accidentally committing your API key.)

4.  **Build and Run:** Build the project in Android Studio and run it on an emulator or physical device.

## Contributing

Contributions are welcome!  Please feel free to submit pull requests with bug fixes, improvements, or new features.
