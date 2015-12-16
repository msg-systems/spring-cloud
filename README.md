# spring-cloud
## Prerequisites
### Set up Java8 JDK
* Set up Java developer kit (JDK) not Java runtime environment (JRE)
* Set JAVA_HOME and PATH environment variables.
* See [Oracle JDK 8 installation overview](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
### Set up GIT client
* See [Github.com documentation] (https://help.github.com/articles/set-up-git/)
* Set up proxy server (if required)
Command to use :
```bash
git config --global http.proxy http://proxyuser:proxypwd@proxy.server.com:8080
git config --global https.proxy https://proxyuser:proxypwd@proxy.server.com:8080
```
* change proxyuser to your proxy user
* change proxypwd to your proxy password
* change proxy.server.com to the URL of your proxy server
* change 8080 to the proxy port configured on your proxy server

* If you decide at any time to reset this proxy and work without (no proxy):
Commands to use:
```bash
git config --global --unset http.proxy
git config --global --unset https.proxy
```

* Finally, to check the currently set proxy;
```bash
git config --global --get http.proxy
git config --global --get https.proxy
```

### Set up Apache Maven
* See [Apache Maven documentation] (https://maven.apache.org/install.html)
* Set M2_HOME, M2 and PATH variables.
* Set up proxy server (if required) 
Put into your ${user.home}/.m2/settings.xml the correct configuration
```xml
<settings>
  <proxies>
   <proxy>
      <id>example-proxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.example.com</host>
      <port>8080</port>
      <username>proxyuser</username>
      <password>somepassword</password>
      <nonProxyHosts>www.google.com|*.example.com</nonProxyHosts>
    </proxy>
  </proxies>
</settings>
```
* change proxyuser to your proxy user
* change somepassword to your proxy password
* change proxy.example.com to the URL of your proxy server
* change 8080 to the proxy port configured on your proxy server

### Set up your favorite IDE
* [IntelliJ IDEA] (https://www.jetbrains.com/idea/)
* [NetBeans IDE] (https://netbeans.org/)
* [Eclipse IDE for Java EE Developers] (https://eclipse.org/)
* [Spring Eclipse IDE] (https://spring.io/tools/eclipse)
* Set up proxy server in your IDE (if required)
#### Install lombok plugin
* See [Lombok documentation] (https://projectlombok.org/download.html)
* NetBeans: Just put lombok.jar on the classpath and enable annotation processing. More…
* Eclipse and variants: Run lombok.jar as a java app (i.e. doubleclick it, usually) to install. Also add lombok.jar to your project. Supported variants: Springsource Tool Suite, JBoss Developer Studio. Update Maven Projects. 
* IDEA IntelliJ	A plugin developed by Michael Plushnikov adds support for most features.

## Check out the code
* If you use {user.home}/workspace/ as your workspace directory this GIT repository will be cloned to {user.home}/workspace/spring-cloud 
* Ether use your IDE
* Or clone the repository 
```bash
git clone https://github.com/Pirat83/spring-cloud.git
```
## Getting started
Use the location where you cloned the repository i.e. {user.home}/workspace/spring-cloud to execute the following commands. 
Important endpoint URLs: 
data-collection-service: [http://localhost:8000/sensorData](http://localhost:8000/sensorData)
### Build all modules
```bash
mvn clean install
```
### Start Eureka-Server 
```bash
java -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar
```
to verify if your eureka-server has started correctly on port 8761 open with your browser [The Eureka Dashboard](http://localhost:8761/). 
### Start data-collection-service
```bash
java -jar data-collection-service/target/data-collection-service-0.0.1-SNAPSHOT.jar --server.port=8000
```
verify [The SensorData endpoint: http://localhost:8000/sensorData](http://localhost:8000/sensorData). You should see some JSON objects. 
### Start maintenance-service
```bash
java -jar maintenance-service/target/maintenance-service-0.0.1-SNAPSHOT.jar --server.port=8010
```
verify [The maintenance endpoint: http://localhost:8010/](http://localhost:8010/). You should see an error message, due no instance of car-repair-service is found yet.   
### Start car-repair-service
```bash
java -jar car-repair-service/target/car-repair-service-0.0.1-SNAPSHOT.jar --server.port=8020
```
verify [The car-repair endpoint: http://localhost:8020/](http://localhost:8020/). You should see an error message, due no instance of master-data-service is found yet.   
### Start master-data-service
```bash
java -jar master-data-service/target/master-data-service-0.0.1-SNAPSHOT.jar --server.port=8030
```
verify [The master-data endpoint: http://localhost:8030/car](http://localhost:8030/car). You should see an customer JSON object.     
### Start appointment-service
```bash
java -jar appointment-service/target/appointment-service-0.0.1-SNAPSHOT.jar --server.port=8040
```
verify [The customer appointment endpoint: http://localhost:8040/customer](http://localhost:8040/customer). You should see an long value.     
verify [The service-centerappointment endpoint: http://localhost:8040/service-center](http://localhost:8040/service-center). You should see an long value.

### Putting everything together
Now you got everything running. Verify that all 5 running spring-cloud are running. [Eureka application inventory](http://localhost:8761/eureka/apps/) 

So lets schedule an maintenance. Navigate to: [The maintenance endpoint: http://localhost:8010/](http://localhost:8010/) 
You see an Error, due a bug. There is a missing ribbon dependency. This will be fixed soon. The maintenance-service should post a CarMaintenanceEvent to the car-repair-service. 
Let's emulate this by navigating to [The car-repair endpoint: http://localhost:8020/](http://localhost:8020/). You see the CarMaintenanceEvent. 

## Useful links: 
* [How to set up environment variables in Linux, Unix, Mac and Windows environments](http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
* [How to set up a Maven HTTP / HTTPS proxy] (https://maven.apache.org/guides/mini/guide-proxies.html) 
* [Spring engineering blog about microservices] (https://spring.io/blog/2015/07/14/microservices-with-spring)
* [Overview of cloud native applications with spring-cloud] (http://projects.spring.io/spring-cloud/spring-cloud.html)
* [Very interesting overview of spring-cloud components by Kenny Bastani] http://www.kennybastani.com/2015/07/spring-cloud-docker-microservices.html
* [Simple overview of spring-cloud components] (http://de.slideshare.net/mstine/dist-sys-wspringclouddeckset)
* [Overview of spring-cloud-netflix components](http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)
* (Configuration of Hystrix) [https://github.com/Netflix/Hystrix/wiki/Configuration]