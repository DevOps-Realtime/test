pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                withCredentials([string(credentialsId: 'GITHUB', variable: 'GIT_PAT')])
                sh "git clone https://$GIT_PAT@github.com/DevOps-Realtime/test -b ${BRANCH_NAME}" 
            }
        }
    }
}