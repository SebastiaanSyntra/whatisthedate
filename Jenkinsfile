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
                deploy adapters: [tomcat9(path: '', url: 'http://localhost:8080/')],
                contextPath: 'whatisthedatum',
                war: 'target/*.war'

            }
        }
    }
}
