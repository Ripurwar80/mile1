pipeline {
    agent 
    {
        
        //any
        label 'ec2-general-worker-node'
    }
    tools { 
        maven "maven" 
        jdk "java"
        dockerTool "myDocker"
        terraform "terraform2"
    }
//     environment {
//         registry = "360433695343.dkr.ecr.ap-south-1.amazonaws.com"
//         dockerImage = ''
//     }

     stages {
      stage("Git Checkout") {
          steps {
              // credentialsId 'aws'
              git 'https://github.com/JasjitSinghRudra/mile1.git'
              
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
       }

       stage("Build Image") {
           steps {
               //sh 'systemctl start docker'
               sh 'docker build -t pronoobs_ecr .'
               sh 'docker tag pronoobs_ecr:latest public.ecr.aws/j3o7z4s0/pronoobs_ecr:latest'
           }
       }
       
   //      stage("Deploy Image") {
     //      steps {
           //    sh 'docker login --username AWS --password-stdin public.ecr.aws/j3o7z4s0'
              // sh 'docker login --username AWS -p eyJwYXlsb2FkIjoiSWRsUUxvQmJFVGtOLytSd0tkYkdZTkZBZW1UdXUyck9TenYvUmUyZGhiMUZYMGZrWGo2QWZHTkcrRXROdXlTdytHMWxXblFOZnduMXBlNzhQUXpYQVNYYU9zMWs3OCsyNnN0YWNzLzFsZG9oSngwVGdtaFJEeUZ2Z1U0aFdOQ2hmUlF4blg4Qjh3T0F4N1dwYW1vc2JveVZnOUVMQlF1RG5oNTVlVEd3TGNPSHI5T1FsZS9RWTZTd3JkbmNRSWFTK0RWSGtJcms5OWlYZXFZV29YVEpQL3NtL1FWU1RuQ1AvVnJzc0U5cEFtZFJzMHpRYUtBdnBCMHRCMzhZczZiVDgrcWtyNGlNSysvdm9jOFdQMENxRUtTbVNqdWFKaE1vNkVBcENvOWZOSEdSamdFUnFqdEsxZUN6a01HSWEvMS9jUHh2TkJGOWFyd1k0WjJkWjlBUWt6bkVhWWFDZWhtaXBPZXMwdDJScTNFblVhNEFBRTRSSGZCZ2Uzdy83UjZwMGg0VGY1L0lWTHVnR29oRWtFYXVOWEFDOUl2MkZ1WmpmeEFKNGdFZTNUTnAyOGFmZUt1R21JcFZNWEVJeFpjbEdNQkRuR25FbTBYazU5cktCaGVFeWdLakhnS3dDV2xLNUdWYVFXR1cxei9jVHFWM1gvTG1tYnJFc0swS0ZHZHV5dUN6QURlVU4ybGVqRWd4ZE9xNjZYVDl5QnlRNjU1aUsxRkVBOExOV0RBV1ZHRmI3UnVHU0hPaXVTZFdVZzJFUlhrTFVYVG9rb0xIVll0Q1ZxZit2WDNhNm1pOUkxTm5IKzBheDU2Y2o3b3VaWUlZTUtqL0wxeEc2M2U0cDBCazBaSEZ1VnZKTFpJaVVlMGZvY3Z2MjJaaHF5cGhrcjRIRUJ6RE1kMmEvSXhqV2d1TXJiUXAzWWE0aTdwOEdqOWVHVFAyVW0rWmNuMkx0UzFOOXpxUjZ5SUtYUXNQZU9xZTFPN1g0V0tncFdDUDRCVDQ1ZjIzeDFEQ1BXRWRmcFdlR1hRTmp3aDA4bHNvWWhLcWdxZG40NFpIeFRhQkwzQllSN09VVit5NFBzUGZndE00U2JUakhZdEE3R0IwbmVyZmRHOUJvNVJvRDVzNGFJRTJPTUxiUjVHc0pNYW1SNUI5WWdlenp3RWdNb0ZOWXNkWC9pZmlzK2hyWms0a2ZNM21La2Q3b2hnS3dZSGlTdFZYT3RQYUpYWnZIVjNhclF0bWJrRlpEMFQ0bHJjeXpsemFqTXV1cEFPSlRQa2RLT2JTQUQ5V1YvTVhoQnFyMUc0cDBlWUpLN1VaM0FnNVBVNU5ldVA3R3lSV3dmRVVEQ2FOWm85N0xXKy9xanFYU2xlTEpTNE5NeGV6NTBrRWt6UEVPUTJiOXVidFpMaDhQbzdYOGR2cVozdWVjNExWVDBKS2NmYXlUT1o3Uk0rRXZ5Y0hHRzdDY0lDMzkvcjNuTlNuSWVSbHpnT3Q4VG1KNUJzSEJUWUdwTXBIT1NaQyt3Z2pwOWtjb1Z5VHlWZG8zYUxWODRQYkxIYTQyTnhxNXJZT1VTUlBvRlB6YXBKRkxCdjVtb1llMHdhUWpVNEUxUnhwSWxWUnl5aWJ3WWxHdlpCZ0Q4WVV4L09HTnh6bjN1eno2SmRLSUxiVE5TdkFQdEZtRkNTMXRYMisrTEFhNlg4YVhGVjZIWXVHcnRoVFQ3eWk1TndTQnNicEZ0RGEzdnY4Z0c0dENlSlJQUGJNeVN6aEk5bXI5aWE0U0hXTTMvVzI5YjhxWko5WS90OFR1MDM1Q3pWZWdrSUtuOUpSa0xmdml2bHNDQVE5VG4yYWNxU2FTUVIvelFKalMyaVZkaVZTWmVybEpTZGc3a05GNHRUb0txZ1AyS0thckVvd3V4bW1YK1ZGdktmUENFc2VldjBIM2w5aGlLa0Nxc25BcjA4UVFwZDhKZWYyQXdFdlpqQjdUODQ9IiwiZGF0YWtleSI6IkFRSUJBSGlYdldPamxweXJyK0R2SFp3SW11UkgvNWNOL2g5d1RibHY2K3p4MUt3aVhRSEs1YnR4OUE4cDJtVHJsaFJqNjdrSEFBQUFmakI4QmdrcWhraUc5dzBCQndhZ2J6QnRBZ0VBTUdnR0NTcUdTSWIzRFFFSEFUQWVCZ2xnaGtnQlpRTUVBUzR3RVFRTVRUWHFaU2VaS2hab2JDMzhBZ0VRZ0R2NHhaeEgrYnZlcURvd3FFZ2JmYS9JdU42UHRYdWlJWXd0WW4yVmpvS2U2bnVNb0FmeGVDMkJqZGpqd3ZVOWprdmNmWXVrY0ZBMWVYYjgyQT09IiwidmVyc2lvbiI6IjIiLCJ0eXBlIjoiREFUQV9LRVkiLCJleHBpcmF0aW9uIjoxNjI4MTAzOTI4fQ= public.ecr.aws/j3o7z4s0'

       //        }
      // }
         stage("Terraform Start"){
             steps{
                 withCredentials([[ $class: 'AmazonWebServicesCredentialsBinding', credentialsId: "DevXInternalDeployment"]])
                 {
                 sh '''
                 docker push public.ecr.aws/j3o7z4s0/pronoobs_ecr:latest  
                 terraform init
                 terraform apply --auto-approve
                 terraform destroy --auto-approve
                  '''
                 
                 }
                    
             }
         }

      stage("Remove Image") {
          steps {
              sh 'docker rmi testing'
          }
      }
  }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
