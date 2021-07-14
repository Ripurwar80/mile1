pipeline {
    agent any

    environment {
        registry = "360433695343.dkr.ecr.ap-south-1.amazonaws.com"
        dockerImage = ''
    }

     stages {
      stage("Git Checkout") {
          steps {
              git "https://github.com/Arsator/Milestone1"
          }
      }


      stage("Build") {
          steps {
              sh 'mvn -B -DskipTests clean package'
          }
      }

      stage("Unit Test") {
          steps {
              sh 'mvn test'
          }

          post {
              always {
                  junit 'target/surefire-reports/*.xml'
              }
          }
      }

      stage("Build Image") {
          steps {
              sh 'docker build -t testing .'
              sh 'docker tag testing:latest 360433695343.dkr.ecr.ap-south-1.amazonaws.com/testing:latest'
          }

          post {
              success {
                  sh 'echo Image built successfully.'
              }
          }
      }

      stage("Deploy Image") {
          steps {
              sh 'docker push 360433695343.dkr.ecr.ap-south-1.amazonaws.com/testing:latest'
              }

          post {
              success {
                  sh 'echo deployed success.'
              }
          }
      }

      stage("Remove Image") {
          steps {
              sh 'docker rmi $dockerImage'
          }
      }
  }
}
