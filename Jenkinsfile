pipeline{

    stages{

        stage('Cloning Code from GitHub'){
            steps{
                withCredentials([string(credentialsId: 'GitHub_PAT', variable: 'GITHUB_TOKEN')]){
                    script{
                        // Creating a Branch Variable which use the same branch when code was updated
                        def branchName = env.BRANCH_NAME ?: 'main'

                        // Printing the branch name
                        echo "Cloning code from ${branchName} branch"

                        // Use PAT for authentication in HTTPS
                        sh "git clone https://$GITHUB_TOKEN@github.com/DevOps-Realtime/DevSecOps-Pipeline.git -b ${branchName}"
                        
                    }
                }
            }
        }
    }
}