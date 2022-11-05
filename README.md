Following application is a command line application or script which parses a cron string and expands each field
to show the times at which it will run.

Pre-requisites :
1. maven should be installed. Following article can be referred to setup maven :
https://mkyong.com/maven/how-to-install-maven-in-windows/

2. Java 8 should be available.

3. Go to cmd and go to the project directory and run :
mvn clean install

This will build the project and execute all the underlying test cases that are 
present under src/main/test folder.

4. Above command will also create class files of the project which 
can be used to execute the java code from the command line.

Go to target -> classes folder
D:\data-parser>cd target

D:\data-parser\target>cd classes

D:\data-parser\target\classes>java CronEvaluatorMainClass "0 9 2 11 * /usr/local/bin/yearly_backup"
minute         0
hour           9
day of month   2
month          11
day of week    0 1 2 3 4 5 6
command        /usr/local/bin/yearly_backup

D:\data-parser\target\classes>

5. This project can also be imported to Intellij as a maven project.
File -> Project From Existing Sources -> Select Directory (select maven while importing)

6. Right now only tests for main class and MinuteEvaluator are added , more test classes can be added similarly.

7. if execution of code is to be done without the test cases ,following command can be executed in the main directory:
   D:\data-parser>mvn clean install -DskipTests

8. Test reports are created under directory: \target\surefire-reports

9. Project is structured in a way that the full implementation of the evaluator can be changed by writing another
   implementation of CronEvalutorInterface interface.

10. Similarly implementation of parser of specific elements can be changed by writing implementations of ExpressionEvaluatorInterface
    interface.

java -cp target\data-parser-1.jar com.data.parser.DataParserMainClass orders.csv

mvn clean package spring-boot:repackage
java -jar target/data-parser-1.jar orders.csv orders1.csv orders.json orders1.json