pipeline {
    agent any
    tools{
        maven 'Maven 3.8.6'
        jdk 'jdk8'}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'mvn clean'

            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat 'mvn install'
                deploy adapters: [tomcat9(credentialsId: '3464d71c-e163-49d9-91fe-946c86e8c1f2', path: '', url: 'http://localhost:8080/')],
                contextPath: 'whatisthedate',
                war: 'target/*.war'

            }
        }
    }
}
