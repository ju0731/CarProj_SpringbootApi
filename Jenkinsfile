pipeline {
  agent any
  stages {
    stage('Git cloning') {
      steps {
        git(url: 'https://github.com/bsp-incubation/booking-api.git', branch: 'master', credentialsId: '141f7237-45eb-48d6-91e9-fd7547e5594f')
      }
    }

    stage('Maven Build') {
      steps {
        sh '''cd booking-api
sudo chmod +x mvnw
./mvnw clean package'''
      }
    }

    stage('Compress') {
      steps {
        sh '''cd booking-api
cp target/booking-api-0.0.1-SNAPSHOT.jar ./
tar -cvf back.tar ./booking-api-0.0.1-SNAPSHOT.jar appspec.yml scripts'''
      }
    }

    stage('S3 Upload') {
      steps {
        sh '''cd booking-api
aws s3 cp back.tar s3://landingproject/back.tar'''
      }
    }

  }
}