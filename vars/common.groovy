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
}
