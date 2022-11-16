pipeline {
    agent {label 'Agent1'}

environment {
        imagename = "projectdevops"}

    stages {
        stage('Git') {
            steps {
                git branch :'Dorra' ,url: 'https://github.com/DorraMk/NewProject.git'
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

        stage("Build Sonar ")
        {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=dorra'
              
            }
        }
         stage(" SRC Analysis Testing ")
        {
          steps{
            sh'mvn test'
        }
        post {
            always {
            junit testResults: '*/target/surefire-reports/.xml', allowEmptyResults: true
        }
        }
        }
    }
     
}