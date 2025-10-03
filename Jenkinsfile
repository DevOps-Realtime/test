pipeline {
    agent any
    stages {
        stage('Cleanup Workspace'){
            steps{
                cleanWs()
            }
        }
        stage('Checkout') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'GITHUB_CREDS', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PAT')]) {
                    sh "git clone https://$GIT_USER:$GIT_PAT@github.com/DevOps-Realtime/test -b ${BRANCH_NAME}"
                }
            }
        }
        stage('Build'){
            steps{
                sh "cd $WORKSPACE/test && mvn clean install"
            }
        }
    }
}