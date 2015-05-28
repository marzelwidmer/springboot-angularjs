# AngularJS
 ~/Dev/git/springboot/ops/src/main/resources/static: bower install

# Maven Package
mvn package

# Start App
java -jar target/ops-0.0.1-SNAPSHOT.jar 

# Start App with diffrent port on comandline
java -jar -Dserver.port=9000 -Dshell.telnet.port=3000 -Dshell.ssh.port=3001 target/ops-0.0.1-SNAPSHOT.jar  

# Start App with develpment configuration
java -jar target/ops-0.0.1-SNAPSHOT.jar --spring.profiles.active=development


# Application SSH login
ssh -p 2000 user@localhost
