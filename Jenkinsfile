pipeLine{
    agent any
    tools{
        maven 'Maven 3.8.3'
        jdk 'jdk11'
    }
    stages {
        stage('Build and Test'){
            steps{
                echo 'mvn verify'
                }
            }
        }
    }