pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'jdk8'
    }
    stages {
        stage('Build and Test') {
            steps {
                sh 'mvn verify'
            }
        }
    }
}