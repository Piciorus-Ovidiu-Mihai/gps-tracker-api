# 💻 GPS Tracker
This is an API for a GPS tracker and a to do list application. This project was made using Spring Boot. Also, there is a client project for mobile, using Java and Android Studio. The front-end part was realized with Angular and the repository is available on 🌍[Web](https://github.com/Piciorus-Ovidiu-Mihai/GPS-tracker-web). The purpose of this application is to track the location sent from the mobile application. 
As a future, the web application has a to do list, for everyone who wants to keep their work.

## 🛠️ Architecture
Welcome to the Java Application with Layered Architecture project! This repository showcases a well-structured, layered approach to building robust and maintainable Java applications. Our project is organized into several key packages, each with its unique responsibilities. This project is divided into multiple packages.

* Exception: Handle exceptions gracefully in your application. This package provides a centralized way to manage and propagate exceptions, ensuring a smoother user experience.
* Controllers: Control the flow of your application. Controllers act as intermediaries between user requests and the underlying business logic. They're responsible for routing and handling HTTP requests.
* Mappers: Transform data seamlessly. Mappers are instrumental in converting data between various formats, such as DTOs (Data Transfer Objects) and entities. They promote data consistency and clarity.
* Model: Define your data structures. The model package contains the building blocks of your application. It includes entities, which represent data in your database, and DTOs, which facilitate data transfer between different layers.
* Repository: Manage data persistence. The repository package is all about data storage and retrieval. It often includes database operations and queries to interact with your chosen data store.
* Service: Implement your business logic. Services encapsulate the core functionality of your application. They contain methods for processing, manipulating, and managing data, ensuring that your application behaves as expected.

<p align="center">
  <img src="https://github.com/Piciorus-Ovidiu-Mihai/gps-tracker/blob/main/gps-tracker-api-architecture.png">
</p>

## 📷 Preview 
Stay connected and ensure safety with our Personal GPS Tracker. This app is designed for individuals who want to keep an eye on their loved ones or track their own location. It offers real-time location sharing, geofencing, and history logs, providing peace of mind and security for families and friends. Below it can be observe a preview for the web application.

<p align="center">
  <img src="https://github.com/Piciorus-Ovidiu-Mihai/gps-tracker/blob/main/gps-tracker-section.png">
</p>

## 🛡️ Key Features
* Separation of Concerns: Each layer has a well-defined role, ensuring that specific responsibilities are isolated.
* Scalability: The application can be scaled by focusing on specific layers to accommodate increasing loads or new features.
* Maintainability: Code related to specific concerns can be located, modified, or extended more easily.
* Reusability: Code can be reused, particularly in the service and mapper layers, enhancing development efficiency.
* Testing: The isolation of layers simplifies unit testing and mocking, promoting robust code quality.

## 💽 Prerequisite
* ⚙️ Java SDK
* ⚙️ Android Studio 
* ⚙️ A phone with Android 10 or an emulator 

## 🚀 Getting Started
* ⭐ Clone the repository
* ⭐ Setup the database using MySql
* ⭐ Build & Run Java application
* ⭐ Build & Run Android application

## 🖥️ Technologies
* 📱 `Android`
* 💽 `Spring Boot`
* 💻 `MySql`
* 💻 `Java`
