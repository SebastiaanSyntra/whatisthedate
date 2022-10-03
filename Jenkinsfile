pipeline {
    agent any
    tools{
        maven 'Maven 3.8.6'
        jdk 'jdk8'}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn build'

            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'mvn install'

            }
        }
    }
}
