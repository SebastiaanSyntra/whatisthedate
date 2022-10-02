pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'jdk8'
    }
    stages {
        stage('Build, Test') {
            when {
                not {
                    branch 'main'
                }
            }
            steps {
                sh('mvn clean package')
            }
        }
        stage('Build, Test, Snapshot') {
            when {
                branch 'main'
            }
            steps {
                rtMavenDeployer (
                    id: 'deployer',
                    serverId: 'artifactory',
                    releaseRepo: 'devops-libs-release-local',
                    snapshotRepo: 'devops-libs-snapshot-local',
                )
                rtMavenRun (
                    tool: 'Maven 3.6.3',
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'deployer',
                )
            }
        }
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                deploy adapters: [tomcat9(url: 'http://tomcat-devops.westeurope.cloudapp.azure.com', credentialsId: 'deploy')],
                                            war: 'target/*.war',
                                    contextPath: 'whatisthedate'
            }
        }
    }
}