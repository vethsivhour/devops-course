# devops-course

# Create project using 
```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```

# Hello World Java Desktop Application
This is a simple Java Swing application that displays "Hello, World!" in a window.
A simple Java Swing application that displays "Hello, World!" in a window.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven


## Building the Application

To build the application, run:

```bash
mvn clean compile
```

## Running the Application

There are two ways to run the application:

1. Using Maven exec plugin:
```bash
mvn exec:java -Dexec.mainClass="com.mycompany.HelloWorldApp"
```

2. Building and running the JAR:
```bash
mvn package
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.HelloWorldApp
```

