# People Name Program 1.0

This is a Maven app that implements all requirements of coding challenge.

## Pre-requisites

- Java SE Development Kit 8
- Maven 3.0+

## How to set the parameters to test the program

Open the Program.java class and set the following values:

``` java
public class Program {
    // Set the path of the text file that contains all the data
    public static final String pathTextFile = "D:\\dev\\java2\\app\\src\\main\\resources\\coding-test-data.txt";

    // Set the size of the most common first names or last names
    public static final int RANKING_SIZE = 10;

    // Set the size of the list of modified names
    public static final int LIST_MODIFIED_NAMES_SIZE = 25;
    ...
}
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