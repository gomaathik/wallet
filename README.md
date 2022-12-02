# Wallet Application

A simple wallet microservice running on the JVM that manages credit/debit
transactions on behalf of players.

## Description

Virtual Wallet account keeps the current balance for a player.

The balance can be modified by registering transactions on the account, either debit
transactions (removing funds) or credit transactions (adding funds).

Created a REST API to get each tasks. 

1. Displaying the all the players the total balance. 
2. Displaying the individual player transaction history. 
3. Checking the debit function whether its succeed or not. 
4. Checking the debit/credit function's unique transaction id detail. 

## Building the Project

`./mvnw clean install`

# Running the Project

`./mvn spring-boot:run`

`./mvn spring-boot:start`






