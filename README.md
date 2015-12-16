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
#### Install lombok plugin
* See [Lombok documentation] (https://projectlombok.org/download.html)
* NetBeans: Just put lombok.jar on the classpath and enable annotation processing. More…
* Eclipse and variants: Run lombok.jar as a java app (i.e. doubleclick it, usually) to install. Also add lombok.jar to your project. Supported variants: Springsource Tool Suite, JBoss Developer Studio. Update Maven Projects. 
* IDEA IntelliJ	A plugin developed by Michael Plushnikov adds support for most features.

## Check out the code
* Ether use your IDE
* Or clone the repository 
```bash
git clone https://github.com/Pirat83/spring-cloud.git
```
## Getting started

## Useful links: 
* https://spring.io/blog/2015/07/14/microservices-with-spring
* http://projects.spring.io/spring-cloud/spring-cloud.html
* http://www.kennybastani.com/2015/07/spring-cloud-docker-microservices.html
* http://de.slideshare.net/mstine/dist-sys-wspringclouddeckset
* http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
* https://github.com/Netflix/Hystrix/wiki/Configuration