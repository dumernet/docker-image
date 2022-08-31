podTemplate() {
    node(POD_LABEL) {
        stage('checkout') {
            checkout scm
        }
        stage('Build Symfony') {
            build job: 'docker-image/symfony'
        }
    }
}