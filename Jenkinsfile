pipeline {
    agent {label 'Agent1'}

environment {
        imagename = "projectdevops"}

    stages {
      
        stage("Build Maven") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage("Build Docker image") {
            steps {
                sh 'docker build -t imagename .'
            }
        }

        stage("Build Sonar ")
        {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=dorra2'
              
            }
        }
         stage(" SRC Analysis Testing ")
        {
          steps{
            sh'mvn clean test -P test'
        }
        post {
            always {
            junit testResults: '*/target/surefire-reports/.xml', allowEmptyResults: true
        }
        }
        }
    }
     
}