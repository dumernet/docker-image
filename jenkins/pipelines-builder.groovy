podTemplate() {
    node(POD_LABEL) {
        stage('checkout') {
            checkout scm
        }
        stage('Job Builder') {
            jobDsl targets: ['jenkins/scripts/*.groovy'].join('\n')
        }
    }
}