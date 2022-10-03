pipeline {
    agent any
    tools{
        maven 'Maven 3.8.6'
        jdk 'jdk8'}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                mvn 'build'

            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
                mvn 'install'

            }
        }
    }
}
