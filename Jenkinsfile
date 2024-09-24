pipeline {
  agent any
  stages {
    stage('clone repository') {
      steps {
        sh '''java -version'''
      }
    }

    stage('Deploy billing App') {
      steps {
        withCredentials(bindings: [
                      string(credentialsId: 'k8sToken', variable: 'api_token')
                      ]) {
            sh 'kubectl --token $api_token --server https://192.168.49.2:8443 --insecure-skip-tls-verify=true apply -f k8s_deployment.yml'
          }

        }
      }

    }
}