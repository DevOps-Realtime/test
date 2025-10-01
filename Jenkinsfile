pipeline {
    agent any
    stages {
        stage('Clone Code') {
            steps {
                withCredentials([string(credentialsId: 'GITHUB_PAT', variable: 'GITHUB_TOKEN')]) {
                    sh 'git clone https://$GITHUB_TOKEN@github.com/DevOps-Realtime/test.git -b ${BRANCH_NAME}'
                }
            }
        }
    }
}