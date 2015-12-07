# spring-cloud

## How to set up git to use a proxy when connecting to the internet

Command to use :

```bash
git config --global http.proxy http://proxyuser:proxypwd@proxy.server.com:8080 <br/>
git config --global https.proxy https://proxyuser:proxypwd@proxy.server.com:8080 <br/>
```

* change proxyuser to your proxy user
* change proxypwd to your proxy password
* change proxy.server.com to the URL of your proxy server
* change 8080 to the proxy port configured on your proxy server

If you decide at any time to reset this proxy and work without (no proxy):

Commands to use:
```bash
git config --global --unset http.proxy
git config --global --unset https.proxy
```

Finally, to check the currently set proxy;

```bash
git config --global --get http.proxy
git config --global --get https.proxy
```

## Useful links: 
* http://de.slideshare.net/mstine/dist-sys-wspringclouddeckset
* http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
