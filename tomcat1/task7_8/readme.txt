task 7:
1) для установки приложения на сервер tomcat добавим приложение в каталог CATALINA_HOME\webapps
2) т.к. в tomcat существуют настройки по умолчанию, приложения которые запускаются через хост localhost:8080 и установлены в папку CATALINA_HOME\webapps обладают параметром unpackWARs="true" который отвечает за автоматическую распаковку приложения при запуске сервером приложений
	выполним запров браузере http://localhost:8080/tomcat-quickstart/echo
	получим: Hello from Echo servlet!Tue Dec 22 19:26:52 MSK 2020
	Приложение работает.



task 8:
добавим плагин в фалй pom.xml

            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>tomcat-maven-plugin</artifactId>
                <version>1.1</version>
                <configuration>
                    <url>http://localhost:8080/manager/text</url>
                    <username>tomcat</username>
                    <password>tomcat</password>
                </configuration>
            </plugin>

запустим командную строку в папке с файлом pom.xml
mvn tomcat:info
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:info (default-cli) @ tomcat-quickstart ---
[INFO] Listing server information at http://localhost:8080/manager/text
[INFO] OK - Server info
[INFO] Tomcat Version: [Apache Tomcat/9.0.41]
[INFO] OS Name: [Windows 7]
[INFO] OS Version: [6.1]
[INFO] OS Architecture: [amd64]
[INFO] JVM Version: [11+28]
[INFO] JVM Vendor: [Oracle Corporation]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.456 s
[INFO] Finished at: 2020-12-22T20:44:19+03:00
[INFO] ------------------------------------------------------------------------

mvn tomcat:redeploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] >>> tomcat-maven-plugin:1.1:redeploy (default-cli) > package @ tomcat-quickstart >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ tomcat-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ tomcat-quickstart ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ tomcat-quickstart ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-war-plugin:3.3.1:war (default-war) @ tomcat-quickstart ---
[INFO] Packaging webapp
[INFO] Assembling webapp [tomcat-quickstart] in [D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Building war: D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT.war
[INFO]
[INFO] <<< tomcat-maven-plugin:1.1:redeploy (default-cli) < package @ tomcat-quickstart <<<
[INFO]
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:redeploy (default-cli) @ tomcat-quickstart ---
[INFO] Deploying war to http://localhost:8080/tomcat-quickstart
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/tomcat-quickstart]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.343 s
[INFO] Finished at: 2020-12-22T20:45:39+03:00
[INFO] ------------------------------------------------------------------------

mvn tomcat:undeploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:undeploy (default-cli) @ tomcat-quickstart ---
[INFO] Undeploying application at http://localhost:8080/tomcat-quickstart
[INFO] OK - Удалено приложение по пути контекста [/tomcat-quickstart]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.011 s
[INFO] Finished at: 2020-12-22T20:46:36+03:00
[INFO] ------------------------------------------------------------------------

mvn tomcat:list
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:list (default-cli) @ tomcat-quickstart ---
[INFO] Listing applications at http://localhost:8080/manager/text
[INFO] OK - Список приложений для виртуального хоста [localhost]
[INFO] /:running:0:ROOT
[INFO] /examples:running:0:examples
[INFO] /testWebApp-1.0-SNAPSHOT:running:0:testWebApp-1.0-SNAPSHOT
[INFO] /host-manager:running:0:host-manager
[INFO] /manager:running:1:manager
[INFO] /docs:running:0:docs
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.480 s
[INFO] Finished at: 2020-12-22T20:47:09+03:00
[INFO] ------------------------------------------------------------------------


mvn tomcat:deploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] >>> tomcat-maven-plugin:1.1:deploy (default-cli) > package @ tomcat-quickstart >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ tomcat-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ tomcat-quickstart ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ tomcat-quickstart ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-war-plugin:3.3.1:war (default-war) @ tomcat-quickstart ---
[INFO] Packaging webapp
[INFO] Assembling webapp [tomcat-quickstart] in [D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Building war: D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT.war
[INFO]
[INFO] <<< tomcat-maven-plugin:1.1:deploy (default-cli) < package @ tomcat-quickstart <<<
[INFO]
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:deploy (default-cli) @ tomcat-quickstart ---
[INFO] Deploying war to http://localhost:8080/tomcat-quickstart
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/tomcat-quickstart]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.263 s
[INFO] Finished at: 2020-12-22T20:47:42+03:00
[INFO] ------------------------------------------------------------------------

для сравнения добавим плагин 
           <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <url>http://localhost:8080/manager/text</url>
                    <username>tomcat</username>
                    <password>tomcat</password>
                </configuration>
            </plugin>

mvn tomcat7:undeploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat7-maven-plugin:2.2:undeploy (default-cli) @ tomcat-quickstart ---
[INFO] Undeploying application at http://localhost:8080/tomcat-quickstart
[INFO] OK - РЈРґР°Р»РµРЅРѕ РїСЂРёР»РѕР¶РµРЅРёРµ РїРѕ РїСѓС‚Рё РєРѕРЅС‚РµРєСЃС‚Р° [/tomcat-quickstart]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.435 s
[INFO] Finished at: 2020-12-22T20:51:59+03:00
[INFO] ------------------------------------------------------------------------

mvn tomcat:deploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] >>> tomcat-maven-plugin:1.1:deploy (default-cli) > package @ tomcat-quickstart >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ tomcat-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tomcat-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ tomcat-quickstart ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ tomcat-quickstart ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-war-plugin:3.3.1:war (default-war) @ tomcat-quickstart ---
[INFO] Packaging webapp
[INFO] Assembling webapp [tomcat-quickstart] in [D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Building war: D:\jd02_hw\tomcat1\task7_8\tomcat-quickstart\target\tomcat-quickstart-1.0-SNAPSHOT.war
[INFO]
[INFO] <<< tomcat-maven-plugin:1.1:deploy (default-cli) < package @ tomcat-quickstart <<<
[INFO]
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:deploy (default-cli) @ tomcat-quickstart ---
[INFO] Deploying war to http://localhost:8080/tomcat-quickstart
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/tomcat-quickstart]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.699 s
[INFO] Finished at: 2020-12-22T20:52:31+03:00
[INFO] ------------------------------------------------------------------------

проверим список доступных команд для данного плагина
mvn tomcat7:help
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< it.academy:tomcat-quickstart >--------------------
[INFO] Building tomcat-quickstart 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat7-maven-plugin:2.2:help (default-cli) @ tomcat-quickstart ---
[INFO] Apache Tomcat Maven Plugin :: Tomcat 7.x 2.2
  The Tomcat Maven Plugin provides goals to manipulate WAR projects within the
  Tomcat 7.x servlet container.

This plugin has 14 goals:

tomcat7:deploy
  Deploy a WAR to Tomcat.

tomcat7:deploy-only
  Deploy a WAR to Tomcat without forking the package lifecycle.

tomcat7:exec-war
  Create a self executable jar file containing all necessary Apache Tomcat
  classes. This allows for using just java -jar mywebapp.jar to run your webapp
  without needing to install a Tomcat instance. More details here.

tomcat7:exec-war-only
  Same as exec-war goal without forking the package lifecycle.

tomcat7:help
  Display help information on tomcat7-maven-plugin.
  Call mvn tomcat7:help -Ddetail=true -Dgoal=<goal-name> to display parameter
  details.

tomcat7:redeploy
  Redeploy a WAR in Tomcat. (Alias for the deploy goal with its update parameter
  set to true.)

tomcat7:redeploy-only
  Redeploy a WAR in Tomcat without forking the package lifecycle. (Alias for the
  deploy-only goal with its update parameter set to true.)

tomcat7:run
  Runs the current project as a dynamic web application using an embedded Tomcat
  server.

tomcat7:run-war
  Runs the current project as a packaged web application using an embedded
  Tomcat server.

tomcat7:run-war-only
  Same as run-war goal without forking the package cycle.

tomcat7:shutdown
  Shuts down all possibly started embedded Tomcat servers. This will be
  automatically done through a shutdown hook or you may call this Mojo to shut
  them down explictly.

  By default the shutdown goal is not bound to any phase. For integration tests
  you might want to bind it to post-integration-test.

tomcat7:standalone-war
  This Mojo will create an executable war file with embedded Tomcat that is also
  capable of being deployed elsewhere.

tomcat7:standalone-war-only
  This Mojo will create an executable war file with embedded Tomcat that is also
  capable of being deployed elsewhere.

tomcat7:undeploy
  Undeploy a WAR from Tomcat.


[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.696 s
[INFO] Finished at: 2020-12-22T20:53:24+03:00
[INFO] ------------------------------------------------------------------------
