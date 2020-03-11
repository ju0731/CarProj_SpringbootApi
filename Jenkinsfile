pipeline {
  agent any
  stages {
    stage('Git cloning') {
      steps {
        git(url: 'https://github.com/bsp-incubation/booking-api.git', branch: 'master', credentialsId: 'woodchuckchoi')
      }
    }

    stage('Maven Build') {
      steps {
        sh '''cd booking-api
sudo chmod +x mvnw
./mvnw clean package'''
      }
    }

    stage('S3 Upload') {
      steps {
        sh '''cd booking-api/target
aws s3 cp booking-api-0.0.1-SNAPSHOT.jar s3://landingproject/back.jar
'''
      }
    }

  }
}