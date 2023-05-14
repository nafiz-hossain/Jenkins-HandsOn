# Jenkins-HandsOn

This repository is a collection of resources, examples, and demos to help me learn Jenkins, a popular open-source automation server. It includes associated files, configurations, and scripts to help me get started with Jenkins, and to showcase its various features and use cases. 

## About Jenkins

Jenkins is a leading automation server that can be used to automate all sorts of development tasks, such as building, testing, and deploying software. It has a vast plugin ecosystem and is highly extensible, making it a favorite tool among developers, testers, and DevOps engineers.

## Repository Contents

This repository contains a range of materials to help me learn Jenkins:

- **Tutorials**: A set of step-by-step guides that cover various aspects of Jenkins, from installation and configuration to advanced use cases.
- **Examples**: A collection of example Jenkinsfiles and pipeline scripts that demonstrate how to use Jenkins to build, test, and deploy applications.
- **Demos**: A series of video demos that showcase the features and capabilities of Jenkins in action.
- **Resources**: A curated list of links, books, and other resources that helped me learn more about Jenkins.

## Getting Started

To get started with Jenkins, simply clone this repository and explore the materials. You can follow the tutorials to set up your own Jenkins instance, or dive straight into the examples and demos to see Jenkins in action.

## Contributing

We welcome contributions to this repository! If you have any feedback, suggestions, or ideas for new content, feel free to open an issue or submit a pull request.

# Prerequisites
Before installing Jenkins, ensure that you have the following prerequisites:

A Linux-based operating system (such as Ubuntu or Debian)
Java 8 or Java 11 installed on your machine
Sudo privileges or root access to install packages


# Installation

1. First, update the package list by running the command:
2. sudo apt update
3. Then, install Java 8 or Java 11 (if it is not already installed) by running one of the following commands:
sudo apt install openjdk-8-jdk
or
sudo apt install openjdk-11-jdk





# Here's a brief guide on how to run Jenkins using the WAR file:-

1. Download the latest version of the Jenkins WAR file from the official website: https://www.jenkins.io/download/
2. Place the downloaded WAR file in a convenient location on your Linux machine.
3. Open a terminal and navigate to the directory where the WAR file is located.
4. Run the following command to start Jenkins:
java -jar jenkins.war
Replace "jenkins.war" with the name of the actual WAR file if it is different.


Jenkins will start up and display some logs in the terminal. Wait for the message "Jenkins is fully up and running" to appear.
Open a web browser and navigate to http://localhost:8080 to access the Jenkins web interface.
Follow the prompts to complete the Jenkins setup process.
Note: By default, Jenkins will run on port 8080. If you need to change the port, add the following option to the command when starting Jenkins: --httpPort=<port_number>



By default it will set a password for me, will be available on terminal -
Demo:


*************************************************************
*************************************************************
*************************************************************

Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

748edcd787664b3faa330df11abeccf0

This may also be found at: /home/tigerit/.jenkins/secrets/initialAdminPassword

*************************************************************
*************************************************************
*************************************************************


# Steps
Setup Trigger the Jenkins Build Automatically after every GitHub commits
(Here I am building SeleniumAutomationFramework from github and building periodically after a push)


Steps 1:
Create a new jenkins job, created a job for compile and run a maven project.


Steps 2:
Add github repository url jenkins configuration

Steps 3:

Add a new webhook in github. Setting > Webhook

Steps 4:
Forward localhost ip into public ip by using ngrok

Steps 5:
First I have to install ngrok by `sudo snap install ngrok`
And then I have to sign up in ngrok.com and add my auth token in config by `ngrok config add-authtoken 2PZ8S1nRuxKYSu7ak8HWljUU3T4_3tpPBdoEu8BXb5HabWJoM`

Steps 6:
To run ngrok `ngrok http localhost:8080`

Steps 7:
Copy the new created url and add in Setting>Webhook by adding `/github-webhook/` at the end of the new created URL
and save

Steps 8: Now make a change on main project and push the change into github remote repository and BANGGG.
The code executes itself.
