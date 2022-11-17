pipeline {
    agent {label 'agent'}

environment {
        imagename = "projetachat"}

    stages {
      
        stage(" Unit Testing ")
        {
          steps{
            sh'mvn test -Ptest'
        }
     
        }
        stage("SRC Analysis Testing ")
        {
            steps {
                sh 'mvn sonar:sonar -Pcoverage -Dsonar.login=admin -Dsonar.password=wiss-1998'
              
            }
        }
        stage("Jacoco ")
        {
            steps {
                sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
              
            }
        }
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
	 	stage("Start Containers") {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
     
}