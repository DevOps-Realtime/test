pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                withCredentials([string(credentialsId: 'GITHUB_CREDS', variable: 'GIT_PAT')]){
                sh "git clone https://$GIT_PAT@github.com/DevOps-Realtime/test.git -b ${BRANCH_NAME}"
                } 
            }
        }
    }
}