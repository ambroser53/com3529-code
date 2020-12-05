## 1. Introduction
This repository contains code examples to support the "COM3529 Software Testing and Analysis" module at the University of Sheffield.

## 2. Getting Started

### 2.1 Preferred Operating System and Required Tooling

You are welcome to use your own machine, but we will demonstrate everying using [Codio](https://www.codio.com/), for which you should already have a working account. 

All the required tools are already setup for you on Codio, so there is nothing to do if you are happy to do everything there. However, if you prefer to use your own machine you will need to set these up yourself. If I was taking this module, this is what I would do! Unfortunately, however, the teaching team for this module cannot give you any individual help in setting everything up for each student's individual machine and configuration. However, there is plenty of online help, pointers to which I give below. For this you will need:

* __Git__. You will need Git to clone this repository. See https://git-scm.com/book/en/v2/Getting-Started-Installing-Git.
* __Java 11__. We will be using JDK 11 throughout the module, as the most recent long term support (LTS) version of Java released by Oracle. However, a more recent JDK should also work fine. Prebuilt OpenJDK Binaries are available at https://adoptopenjdk.net/. If you already have one or more installations of Java on your machine, ensure that a Java 11 installation (or later) is the default one used at the command line. For example, some browsers will install a Java Runtime Environment (JRE) on your machine, but this is insufficient for interacting with the code in this repository.
* __Maven__. Maven is a build automation tool, package and dependency manager for Java. It is available at https://maven.apache.org/. Maven makes it easy for us to use different tools and libraries (e.g., JUnit) without needing to download and install them individually, and having to ensure we have updated the `CLASSPATH` environment variable correctly each time. 

### 2.2 Cloning the repository
Open a terminal and change directory to somewhere appropriate on your system. Then type:

``git clone git@github.com:philmcminn/com3529-code.git``

## 3. Compiling and Running

You will notice the repository has a number of top-level directories, e.g. `lecture-examples`, `assignment`, and so on. Each directory contains code that needs to be built and run separately using Maven. You can build these via the command line. If you're using your own machine, you can use an IDE to do this for you, e.g. [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/). However, we will assume that you're using the command line on Codio. 

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


## 4. Problems or Feedback

We welcome any feedback or constructive criticism that you may have.

If you have any problems, please contact the module lecturer, Phil McMinn. Please note that we are limited in the help that we can offer on specific system setups. If you are experiencing difficulties, please use Codio, where we can give you full support if you run into problems. 
