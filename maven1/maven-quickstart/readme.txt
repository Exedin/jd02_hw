Домашнее задание по теме 2: Apache maven
Исспользованные команды:
Task 1:
set JAVA_HOME=d:\java\jdk-11
set PATH=%PATH%;d:\java\jdk-11;d:\java\apache-maven-3.6.3\bin\
Set M2_HOME=d:\java\apache-maven-3.6.3\bin\
check maven:
mvn -version
Task 2:
mvn archetype:generate
maven-archetype-quickstart
groupId: it.academy
artifact: maven-quickstart
version: default
package: default

Task 4:
mvn compile
mvn package
mvn install

variable lifecycle:
mvn clean
mvn clean package
mvn install
mvn site