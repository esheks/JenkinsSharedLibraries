def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       //sh "echo 'running JUnit-test-cases' "
       //sh "echo 'testing must passed to create artifacts ' "
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
        //sh "echo 'Perfoming CodeQualityAnalysis' "
        //sh "mvn sonar:sonar"
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       //sh "saving artifact' "
       sh "mvn clean deploy"
     }
  
  else if ("${stageName}" == "Upload to tomcat")
     {
       //sh "echo 'deploying to tomcat' "
       deploy adapters: [tomcat8(credentialsId: 'landmark-credentials', path: '', url: 'http://172.31.1.168:8080/')], contextPath: null, war: 'target/*war'
     }
}
