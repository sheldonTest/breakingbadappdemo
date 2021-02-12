# breakingbadappdemo
Breaking Bad Explorer Demo App

This is a small demo app to demonstrate the use of the Kotlin programming language and general android development skills.

Release Notes:

1.) The UI is fairly experimental as it uses Jetpack Compose. This was developed and tested using the Canary version of Android Studio.
2.) Because of time constraints I did not include unit test cases or suites
3.) This app should work on Android OS version 5.0 - Current (i.e. Android 11)
4.) The code use CLEAN architecture and the MVVM structural design pattern
5.) There are two screens - a list view and a details view. Although MVVM is the pattern of choice meaning each screen should have its own ViewModel. 
The ViewModel for the details screen was not implemented since its data is being passed on on from the previous screen (i.e. the list view)
6.) This code uses Jetpack Navigation for transitioning between the two screens
7.) Breaking Bad is a fairly violent show.
