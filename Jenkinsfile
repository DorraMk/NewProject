pipeline {
    agent {label 'agent'}

environment {
        imagename = "projetachat"}

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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=wiss-1998'
              
            }
        }
         stage(" SRC Analysis Testing ")
        {
          steps{
            sh'mvn test -Ptest'
        }
     
        }
    }
     
}