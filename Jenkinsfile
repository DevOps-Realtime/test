pipeline {
    agent any

    environment {
        SCANNER_HOME = '/opt/sonar-scanner/bin'
    }

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
        // stage('SonarScan'){
        //     steps{
        //         withSonarQubeEnv('sonarqube') {
        //             sh '''
        //             ${SCANNER_HOME}/sonar-scanner \
        //             -Dsonar.projectName=test \
        //             -Dsonar.projectKey=DevOps-Realtime_test \
        //             -Dsonar.organization=devops-realtime-1 \
        //             -Dsonar.java.binaries=${WORKSPACE}/test/target/classes \
        //             -Dsonar.sources=${WORKSPACE}/test/src/ \
        //             -Dsonar.branch.name=${BRANCH_NAME}
        //             '''
        //         }
        //     }
        // }
        stage('Docker Build'){
            steps{
                script{
                    // Copy WAR to the build context directory
                    sh "cp $WORKSPACE/test/target/spring-boot-example2-0.0.1-SNAPSHOT.war $WORKSPACE/test/"
                }
                sh "docker build -t saikirangude/test-app:latest $WORKSPACE/test"
            }
        }
        stage('Trivy Scan') {
            steps {
                sh 'trivy image --exit-code 1 --severity HIGH,CRITICAL saikirangude/test-app:latest'
            }
        }
        stage('Docker Push'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        docker login -u $DOCKER_USER -p $DOCKER_PASS
                        docker push saikirangude/test-app:latest
                        docker tag saikirangude/test-app:latest saikirangude/petadata:latest
                        docker push saikirangude/petadata:latest
                    """
                }
            }
        }
    }
}