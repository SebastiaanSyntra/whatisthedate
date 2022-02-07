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
                rtMavenResolver (
                    id: 'resolver',
                    serverId: 'artifactory',
                    releaseRepo: 'maven-libs-release',
                    snapshotRepo: 'maven-libs-snapshot'
                )
                rtMavenRun (
                    tool: 'Maven 3.6.3',
                    pom: 'pom.xml',
                    goals: 'clean verify',
                    resolverId: 'resolver'
                )
            }
        }
        stage('Build, Test, Publish') {
            when {
                branch 'main'
            }
            steps {
                rtMavenDeployer (
                    id: 'deployer',
                    serverId: 'artifactory',
                    releaseRepo: 'maven-libs-release-local',
                    snapshotRepo: 'maven-libs-snapshot-local',
                )
                rtMavenResolver (
                    id: 'resolver',
                    serverId: 'artifactory',
                    releaseRepo: 'maven-libs-release',
                    snapshotRepo: 'maven-libs-snapshot'
                )
                rtMavenRun (
                    tool: 'Maven 3.6.3',
                    pom: 'pom.xml',
                    goals: 'clean install',
                    resolverId: 'resolver',
                    deployerId: 'deployer',
                )
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