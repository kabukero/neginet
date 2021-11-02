# People Name Program 1.0

This is a Maven app that implements all requirements of coding challenge.

## Pre-requisites

- Java SE Development Kit 8
- Maven 3.0+

## How to set the parameters to test the program

Open the resources/application.properties file and set the following values:

``` text
pathTextFile=D:\\dev\\java2\\app\\src\\main\\resources\\coding-test-data.txt
mostCommonElementsSize=10
listModifiedNamesSize=25
```

## How to run the program in a terminal

Open a terminal in the root directory of the project that contains the pom.xml:

``` bash
# to build the app
mvn clean package

# to run the unit tests
mvn test

# to run the app
java -jar target/app.jar
```

## How to run the program in an IDE

1. Import the Maven project straight to your Java IDE:
- Intellij IDEA
- Spring Tool Suite (STS)
- Eclipse

2. Run the Program.java class that contains the main method.

## Program output

You can find the output of the program in the resources/program-output.txt file