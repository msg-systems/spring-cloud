# spring-cloud
## Prerequisites
1. Set up Java8
2. Set up GIT client
3. Set up Apache Maven
4. Set up your favorite IDE
5. Install lombok plugin. 
6. Check out the code
6.1 Set up proxy server (if required)
* How to set up git to use a proxy when connecting to the internet
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

## Useful links: 
* https://spring.io/blog/2015/07/14/microservices-with-spring
* http://www.kennybastani.com/2015/07/spring-cloud-docker-microservices.html
* http://de.slideshare.net/mstine/dist-sys-wspringclouddeckset
* http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
* https://github.com/Netflix/Hystrix/wiki/Configuration