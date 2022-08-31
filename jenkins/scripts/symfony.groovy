pipelineJob("docker-image/symfony") {
    definition {
        cpsScm {
            scm {
                scriptPath("symfony/Jenkinsfile.groovy")
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