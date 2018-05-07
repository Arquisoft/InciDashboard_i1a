[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_i1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_i1a)
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_i1a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_i1a)

# InciDashboard_i1a
InciDashboard_i1a
Incident Dashboard reading incidents sent from the IncidentManagement module through Apache Kafka

## Team members
- Pedro Blanco Suárez (UO251935)
- Roberto Pérez Sánchez (UO250973)
- Manuel García Fernández (UO250979)
- Jorge González-Nuevo Bueno (UO251166)
- David Ferreiro Fernández (UO250757)

## Installation of Docker Toolbox
Docker can be installed from https://docs.docker.com/toolbox/toolbox_install_windows/. Once there, we click on the button Get Docker Toolbox for Windows. An installer will be downloaded, and then we need to execute it. The installer launches the “Setup - Docker Toolbox” dialog. Then we press on Next to accept the default options and at last, we press finsih.
The next step will be to verify the installation. To do that, we will execute the Quickstart Launch of Docker. The terminal will setup several configuration aspects for us. Then, the $ of the shell will be prompt.
Now we can execute a command for a brief example of hello world in Docker. To do that, execute docker run hello-world and the next information will be printed on the screen.

### A brief example with Docker Hello-World
 ```
 $ docker run hello-world
 Unable to find image 'hello-world:latest' locally
 Pulling repository hello-world
 91c95931e552: Download complete
 a8219747be10: Download complete
 Status: Downloaded newer image for hello-world:latest
 Hello from Docker.
 This message shows that your installation appears to be working correctly.

 To generate this message, Docker took the following steps:
  1. The Docker Engine CLI client contacted the Docker Engine daemon.
  2. The Docker Engine daemon pulled the "hello-world" image from the Docker Hub.
     (Assuming it was not already locally available.)
  3. The Docker Engine daemon created a new container from that image which runs the
     executable that produces the output you are currently reading.
  4. The Docker Engine daemon streamed that output to the Docker Engine CLI client, which sent it
     to your terminal.

 To try something more ambitious, you can run an Ubuntu container with:
  $ docker run -it ubuntu bash

 For more examples and ideas, visit:
  https://docs.docker.com/userguide/
```

## Installation of Gatling
We will use Gatling for testing the funcionality of the application. First of all we download it from https://gatling.io/download/. We unzip it and install it.

#### Recorder
To ease the creation of the scenario, we will use the Recorder, a tool provided with Gatling that allows you to record your actions on a web application and export them as a Gatling scenario. This tool is launched with a script located in the bin directory (Windows):

```
%GATLING_HOME%\bin\recorder.bat
```

Once launched, the following GUI lets you configure how requests and responses will be recorded. After configuring the recorder, all you have to do is to start it and configure your browser to use Gatling Recorder’s proxy. Then, we use the application deployed in the previous URL and test it as we usually do.

##### Configuration of Recorder
For developing the tests using the recorder, we need some configuration. First of all, we have ti indicate the port that will be listening, in this case 8082. Then, we have to indicate some information of the package in which we want to save the tests, and the className of it. Finally, the output folder (our project) where we are going to save the test case.

###### Proxy
A configuration in the browser needs to be done. We are using Mozilla Firefox to perform our test. In the configuration, we will establish some important parameters of the Proxy. We go to the Proxy Configuration of Mozilla and set the "Manual Configuration". Then, set all the parameters to localhost:8082, and at the bottom, "Don't use proxy for:" we indicate the URLs that take part in the connection and manipulation of the dashboard: 192.168.99.100:8082, www.google.com/maps, maps.googleapis.com.

##### Recording the tests
Finally, we start the recording and navigate through the dashboard as a normal user would be. Gatling, automatically will generate some tests in the URL of the project that we previously specified, in the package and class name provided.

#### Gatling
Finally, we will execute Gatling to run the produced test.

```
%GATLING_HOME%\bin\gatling.bat
```

##### Recording HAR file
Another way to generate an .scala file containing the test cases is through a HAR file. To record it, we have to select the web developer options in the navigator, for example Chrome. In the Network tab, we ensure that the red circle at the left is in red, and we check if i is not checked the "Preserve Logs" box. After that we try to reproduce what we want to record. Finally, when we finish, eithin the netwok tab of the web developer view, right click and Save content in HAR file.

##### Adding the HAR file to the project with the Gatling Recorder
The final step is done with Gatling recorder. We have to choose the HAR file option in the top right corner of the window. Then we give a name for the test case class generated and the output folder in our project. Automatically, Gatling will generate the .scala test case and will add it to the project.

## Cucumber integration
Cucumber is used in the Incidence Dashboard Spring Boot project for enhancing the test section.

With Cucumber the development team is able to make tests that can be run in front of the client. If they pass, then the application is running within expectations.

Definitely, is the best approach to 'mix' User Stories and tests. That is, by writing User Stories the team will be able to test application functionalities.

### Instalation
Get started with Cucumber in Spring Boot is as simply as adding new dependencies to the Maven _pom.xml_ file. That is:

```
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>2.4.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>1.2.4</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-spring</artifactId>
    <version>1.2.4</version>
    <scope>test</scope>
</dependency>
```

Taking into account that in this case the wanted version is for Java with not support to lambda expressions (API 8).

### Behavour-Driven Development with Cucumber
The main schema is:
* Behavour: Mentioned User Stories.
* Specification by example.
* Executable specifications.
    
And one example (called Scenario in Cucumber) could be:

```
Feature: User management

Scenario: Create first user

  Given there are no users
  When I create a user "Pepe" with password "Pepe12"
  Then The number of users is 1
```

The Scenario should be saved in a _.feature_ file like ```user_management.feature```.

And finally the steps should be defined as...

```
@Given("^there are no users$")
public void there_are_no_users() throws Throwable 
{
    users = new UserDb();
}

@When("^I create a user \"(.+)\" with password \"(.+)\"$")
public void i_create_a_user(String name, String password)
throws Throwable 
{
    users.addUser(name,password);
}

@Then("^The number of users is (\\d+)$")
public void the_number_of_users_is(int n) throws Throwable 
{
    assertThat(users.size()).isEqualTo(1);
}
```

... in a Java Class that sets the steps of the User Story.
