pipeline {
    agent {label 'agent'}

environment {
        imagename = "projetachat"
        DOCKERHUB_CREDENTIALS=credentials('docker_hub')}

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
        stage("Build Maven") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
         stage("Build Docker image") {
            steps {
                sh 'docker build -t wissalbenrhouma/devops_project:latest .'
            }
        }
         stage("Login") {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS'
            }
        }
        
        stage('Push') {

			steps {
				sh 'docker push wissalbenrhouma/devops_project:latest'
			}
		}  
	 	stage("Start Containers") {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
     
}