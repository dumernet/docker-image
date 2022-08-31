podTemplate(
        containers: [containerTemplate(name: 'docker', image: 'docker', command: 'sleep', args: '99d')],
        volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]) {
    node(POD_LABEL) {
        stage('checkout') {
            checkout scm
        }
        stage('Build Symfony') {
            container('docker') {
                sh 'docker build . -t dumernet/symfony -f symfony/Dockerfile'
            }
        }
        stage('Docker Login') {
            container('docker') {
                withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'docker login -u $USERNAME -p $PASSWORD'
                }
            }
        }
        stage('Push Image') {
            container('docker') {
                sh 'docker push dumernet/symfony'
            }
        }
    }
}