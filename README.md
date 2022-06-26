## Introduction

Search Android

This is a simple app for fetching a list of repositories from the Github server. A user can simply search android related repositories by entering a key/name (eg: Android).

## App structure

I've set up a clean architecture with MVVM design pattern to develop this app with the latest Android Jetpack Components.
The main components of the app are following:

1. Jetpack Compose
2. Jetpack Navigation Component for compose
3. View model
4. Hilt
5. Flow
6. Room Database
7. Kotlin Couroutines
8. Retrofit

## Testing

I've used Junit4 to perform the data caching test with Room Database.
Google truth library has been used to evaluate the values of the test results.
