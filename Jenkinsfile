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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=dorra2'
              
            }
        }
        stage("Build Maven") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
         stage("Build Docker image") {
            steps {
                sh 'docker build -t dorramk/my_devops:latest .'
            }
        }
         stage("Login") {
            steps {
                sh 'docker login -u dorramk -p dorra1997'
            }
        }
        
        stage('Push') {

			steps {
				sh 'docker push dorramk/my_devops:latest'
			}
		}  
	 	stage("Start Containers") {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
     
}