Исспользованные команды:
Set java home:
set JAVA_HOME=d:\java\jdk-11
Set path:
set PATH=%PATH%;d:\java\jdk-11;d:\java\apache-maven-3.6.3\bin\
Set m2_home:
Set M2_HOME=d:\java\apache-maven-3.6.3\bin\
check maven:
mvn -version

create project:
mvn archetype:generate
choose template:
maven-archetype-quickstart
groupId: it.academy
artifact: maven-quickstart
version: default
package: default

mvn compile
mvn package
mvn install

variable lifecycle:
mvn clean
mvn clean package
mvn install
mvn site

