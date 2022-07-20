# NYTimesMostPopular

## Summary
Android App written in Kotlin using MVVM Clean Architecture listing the most popular news articles from New York Times newspaper.
In search button i am opening the Dialog to choose the period for the news

## Technologies Used
- Kotlin
- Coroutines
- LiveData
- MVVM Clean Architecture
- Android Architure Components under Android Jetpack
    - NavigationView for navigation between fragments
    - Room Database for local caching
    - ViewModel for a lifecycle aware datastore
- Dagger2 for Dependency Injection
- Retrofit for remote API calls

## Setup & Installation
  - Download & Install [Android Studio](https://developer.android.com/studio)
  - Create an emulator using `Tools > AVD Manager > Create Virtual Device...`
  - Clone the project from github using this link https://github.com/joe-abouassi/NYTimesMostPopular.git
  - Build & Run the project using `Run > Run 'app'` or the following command `./gradlew installDebug`

### Unit Tests
Run the tests using either class by class `Right-Click > Run 'TestClassName'` or by using the following command from terminal window `./gradlew test`

