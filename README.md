# weather-application
A simple weather app created with Java

## Table of Contents
* [Introduction](#introduction)
* [Improvements](#improvements)
* [Technologies](#technologies)
* [Setup](#setup)

## Introduction
This is a simple weather app created with Java and uses JavaFX for the user interface. The weather data is retrieved using the OpenWeatherMap API and deserialised, using the gson library, into a Weather object. Feaures of the application include:
* Weather data is retrieved and displayed on the user interface
* A refresh button to retrieve the latest data from the API
* A combobox containing some cities. 
  * The data in the UI is changed accordingly when a different city is selected

There is a limiting factor imposed due to the tiers. For example, the free tier may not be suitable for widespread use of the application (depending on the number of users) as there is a limit to the number of API calls
<img src="https://user-images.githubusercontent.com/72221490/96188170-35c9cb80-0f36-11eb-80d3-b7376db4123e.png" alt="Image of weather application" width="300">

## Improvements

Some impovements that could be added:
* The ability to select and/or search from a list of cities
* Improving the user interface
* Adding more data about current weather details
* View the weather forecast
* Be able to change settings such as switching between metric and imperial
* Automatically detect location of user
  * As well as setting a default city to display on opening the application
* The applciation should automatically refresh
  * However, this option may be fairly limited since the frequency of weather data updates depends on type of subscription you have (ranging from 10 minutes to 2 hours)

## Technologies
This project is created with:
* Java 13.0.1
* JavaFX 14
* Maven
* Gson 2.8.6
* OpenWeatherMap API

## Setup
To run this project:
1. Fork this project to add it to your own github account
2. Download the project or clone the project to get a local copy
3. Import the project into your IDE
4. Run the project



