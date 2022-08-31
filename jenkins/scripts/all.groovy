pipelineJob("docker-image/all") {
    definition {
        cpsScm {
            scm {
                scriptPath("Jenkinsfile.groovy")
                git {
                    remote {
                        url("https://github.com/dumernet/docker-image.git")
                    }
                    branch("*/develop")
                }
            }
        }
    }
}