pipeline {
    agent any
  stages {
      stage("Git Checkout") {
          steps {
              git "https://github.com/Arsator/Milestone1"
          }
      }

      stage("Build Image") {
          steps {
              script{
                  sh 'docker build -t arsator/milestone1:1.0 .'
              }
          }
      }

      stage("Run Image") {
          steps {
              script {
                  sh 'docker run -it arsator/milestone1:1.0 app.py'
              }
          }
      }
  }
}