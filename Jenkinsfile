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
        stage('Docker Build & Push'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        docker login -u $DOCKER_USER -p $DOCKER_PASS
                        docker build -t saikirangude/test-app:latest $WORKSPACE/test
                        docker tag saikirangude/test-app:latest saikirangude/petadata:latest
                        docker push saikirangude/petadata:latest
                    """
                }
            }
        }
    }
}