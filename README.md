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

# Installation of Docker Toolbox
Docker can be installed from https://docs.docker.com/toolbox/toolbox_install_windows/. Once there, we click on the button Get Docker Toolbox for Windows. An installer will be downloaded, and then we need to execute it. The installer launches the “Setup - Docker Toolbox” dialog. Then we press on Next to accept the default options and at last, we press finsih.
The next step will be to verify the installation. To do that, we will execute the Quickstart Launch of Docker. The terminal will setup several configuration aspects for us. Then, the $ of the shell will be prompt.
Now we can execute a command for a brief example of hello world in Docker. To do that, execute docker run hello-world and the next information will be printed on the screen.

 ```$ docker run hello-world
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
  https://docs.docker.com/userguide/```
