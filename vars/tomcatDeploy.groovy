def call(credId,username,ipAddr){
  sshagent(['credId']) {
    sh "target/*.war target/webapp.war"
    sh "scp target/*.war ${username}@${ipAddr}:/opt/tomcat9/webapps/"
    sh "ssh ${username}@${ipAddr} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${username}@${ipAddr} /opt/tomcat9/bin/startuo.sh"
  }
 }
