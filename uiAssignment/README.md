# UI

This project is a test setup developed on top of Maven + Selenium Webdriver + JUnit5 , to test UI.

UI Website Details -
http://cafetownsend-angular-rails.herokuapp.com/

*Tested on* 

JDK 8

Maven 3.8.2

Chrome 78

Support for firefox has been added in setup file which can be extended to more client browsers

# Installation 

To Run test cases on your machine

## PreRequisite

Maven and JDK should be installed

Valid attributes should be updated in config.properties in resource folder

If getting error - chromedrive is not executable - then run "chmod +x chromedriver" command in terminal at resource folder to give permission.

## 1. Go to root of folder and run below commands

mvn clean test
