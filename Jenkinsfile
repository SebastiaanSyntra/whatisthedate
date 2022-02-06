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
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                deploy adapters: [tomcat9(url: 'http://localhost:1111/', credentialsId: 'ea3d3e64-dd53-4f43-b5a3-4161de5b2588')],
                                            war: 'target/*.war',
                                    contextPath: 'whatisthedate'
            }
        }
    }
}