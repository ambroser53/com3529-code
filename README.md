## 1. Introduction
This repository contains code examples to support the "COM3529 Software Testing and Analysis" module at the University of Sheffield.

## 2. Getting Started

### 2.1 Preferred Operating System
You are welcome to use your own machine, but everything will be demonstrated using [Codio](https://www.codio.com/) for which you will have an account. All the required tools are setup for you on Codio --- if you use your own machine you will need to set these up. 

Unfortunately we cannot give individual help for each person's specific machine configuration. However, there is plenty of online help. You will need to install:

* __Git__. You will need Git to clone this repository. See https://git-scm.com/book/en/v2/Getting-Started-Installing-Git.
* __Java 11__. JDK 11 is preferred, but a more recent JDK should also be fine. Prebuilt OpenJDK Binaries are available at https://adoptopenjdk.net/.
* __Maven__. Maven is a build automation tool, package and dependency manager for Java. It is available at https://maven.apache.org/.

### 2.2 Cloning the repository
Open a terminal and change directory to somewhere appropriate on your system. Then type:

``git clone git@github.com:philmcminn/com3529-code.git``

## 3. Compiling and Running

You will notice the repository has a number of top-level directories, e.g. "lecture-examples", "assignment", and so on. Each directory contains code that needs to be built and run separately using Maven. You can build these via the command line. If you're using your own machine, you can use an IDE to do this for you, e.g. [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/). However, we will assume that you're using the command line on Codio. 

For instance to build the code in the examples directory, you first need to change to that directory in the terminal:

``cd examples``

To compile all the examples, issue the Maven command:

``mvn compile``

To compile all the tests, issue the Maven command:

``mvn test-compile``

To run all of the tests in an individual class:

``mvn -Dtest=PhilTest test``

To run a specific test:

``mvn -Dtest=PhilTest#abEqual test``




