

![Travis Build](https://travis-ci.org/marzelwidmer/springboot-angularjs.svg?branch=master)

[http://marzelwidmer.github.io/springboot-angularjs/](http://marzelwidmer.github.io/springboot-angularjs/)


#### AngularJS 
 springboot-angularjs/src/main/resources/static: bower install
 
  (https://github.com/jmarquis/angular-hateoas)

#### Maven Package
mvn package

#### Start App
java -jar target/springboot-angularjs-0.0.1-SNAPSHOT.jar 

#### Start App with diffrent port on commandline
java -jar -Dserver.port=9000 -Dshell.telnet.port=3000 -Dshell.ssh.port=3001 target/springboot-angularjs-0.0.1-SNAPSHOT.jar  

#### Start App with develpment configuration
java -jar target/springboot-angularjs-0.0.1-SNAPSHOT.jar --spring.profiles.active=development

#### Application SSH login
ssh -p 2000 user@localhost


##### Log REST API
request :
```
{
 "clientApplikation":"SPA",
 "clientVersion":"1.0",
 "correlationId": "11212",
 "debugInformation":"Hello World",
 "faultMessage":"Hello World Message",
 "faultCode":"289-36",
 "faultType":"DATEN",
 "severity":"DEBUG"
  }
```
response :
```{}```