# BLOCKCHAIN CHALLENGE

<p align="center">
  <img src="images/logo.jpg" width="250" height="250"/>
</p>

## Description

FRIDAY is The Fork new web automation testing framework that will replace the well-known JARVIS project. It will cover TFM3 and WNG tests. It is being developed by the QA team using Java, Gradle, Selenium and Zalenium.

## Quickstart

Assuming Google Chrome and Git installed:

```bash
# install java 11 (skip if already installed)
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk11

# install chromedriver (skip if already installed)
brew cask install chromedriver

# clone the project and launch the tests
git clone git@github.com:facundorosonovich/blockchain-challenge.git
cd blockchain-challenge
./gradlew test 
```

This will execute all the tests using your local Chrome browser.


## Developer Installation

To install the dependencies we use *brew*. You can install it from here: <https://brew.sh/>

## 1. Install git

```bash
brew install git
```

## 2. Install Java 11 SDK

```bash
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk11
```

Test that java 11 is correctly installed with

```bash
java -version
```

If it was correctly installed you should see something like

 ```bash
openjdk version "11.0.6" 2020-01-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.6+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.6+10, mixed mode)
```

## 3. Install Gradle

```bash
brew install gradle
```

## 4. Install IntelliJ IDEA CE

IntelliJ IDEA CE can be install from the jetbrains website: <https://www.jetbrains.com/idea/download/#section=mac>  
It can also be installed using brew:

```bash
brew cask install intellij-idea-ce
```

For latest brew versions, please use

```bash
brew install --cask intellij-idea-ce
```

## 5. Install chromedriver

```bash
brew cask install chromedriver
```

For latest brew versions, please use

```bash
brew install --cask chromedriver
```

## 6. Install geckodriver

To test with firefox we need to install the geckodriver

```bash
brew install geckodriver
```

## 7. Install selenium server standalone

```bash
brew install selenium-server-standalone
```


