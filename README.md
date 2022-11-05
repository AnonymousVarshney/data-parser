Following application is a command line application or script for parsing incoming data and converting the result 
of the parsing into the resulting format.

Pre-requisites :
1. maven should be installed. Following article can be referred to setup maven :
https://mkyong.com/maven/how-to-install-maven-in-windows/

2. Java 8 should be available.

3. Go to cmd and go to the project directory and run :
mvn clean install

This will build the project and execute all the underlying test cases that are 
present under src/main/test folder.

4. Files can be stored in the resources location

Files can be of two types for present implementations csv and json .
For exp: 

orders.csv
Order ID,amount,currency,comment
1,100,USD,order payment
2,123,EUR,order payment
3,345.0

orders.json (single json objects)
{"orderId":5, "amount":1.23, "comment": "order payment"}

orders1.csv
Order ID,amount,currency,comment
9,100,USD,order payment
10,123,EUR,order payment
11,345.0

orders1.json (List of json objects)
[{"orderId":6, "amount":1.23, "currency": "USD", "comment": "order payment"},
{"orderId":7, "amount":1.24, "currency": "EUR", "comment": "order payment"}]

Result would be as in Step 6

6. Above command will also create class files and jar of the project which 
can be used to execute the java code from the command line.


D:\data-parser>java -jar target/data-parser-1.jar orders.csv orders1.csv orders.json orders1.json
{"orderId":1,"id":1,"line":1,"filename":"orders.csv","amount":100.0,"currency":"USD","comment":"order payment","result":"OK"}
{"orderId":2,"id":2,"line":2,"filename":"orders.csv","amount":123.0,"currency":"EUR","comment":"order payment","result":"OK"}
{"orderId":3,"id":3,"line":3,"filename":"orders.csv","amount":345.0,"currency":null,"comment":null,"result":"error"}
{"orderId":9,"id":9,"line":1,"filename":"orders1.csv","amount":100.0,"currency":"USD","comment":"order payment","result":"OK"}
{"orderId":10,"id":10,"line":2,"filename":"orders1.csv","amount":123.0,"currency":"EUR","comment":"order payment","result":"OK"}
{"orderId":11,"id":11,"line":3,"filename":"orders1.csv","amount":345.0,"currency":null,"comment":null,"result":"error"}
{"orderId":5,"id":5,"line":1,"filename":"orders.json","amount":1.23,"currency":null,"comment":null,"result":"error"}
{"orderId":6,"id":6,"line":1,"filename":"orders1.json","amount":1.23,"currency":"USD","comment":"order payment","result":"OK"}
{"orderId":7,"id":7,"line":2,"filename":"orders1.json","amount":1.24,"currency":"EUR","comment":"order payment","result":"OK"}

6. This project can also be imported to Intellij as a maven project.
File -> Project From Existing Sources -> Select Directory (select maven while importing)

7. If execution of code is to be done without the test cases ,following command can be executed in the main directory:
   D:\data-parser>mvn clean install -DskipTests

8. Project is structured in a way that the full implementation of the parser can be changed by writing another
   implementation of DataParserInterface interface.


