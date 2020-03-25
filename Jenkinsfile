pipeline {
  agent any
  stages {
    stage('Git cloning') {
      steps {
        git(url: 'https://github.com/bsp-incubation/booking-api.git', branch: 'master', credentialsId: 'boyeon', poll: true)
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

    stage('Create Deployment') {
      when {
        branch 'boyeon2'
      }
      steps {
        sh '''aws deploy create-deployment \\
    --application-name CRBS-codedeploy-app \\
    --deployment-config-name CodeDeployDefault.AllAtOnce \\
    --deployment-group-name $DG_NAME \\
    --s3-location bundleType="tar",bucket="landingproject",key=back.tar \\
    --file-exists-behavior "OVERWRITE"'''
      }
    }

  }
  environment {
    DG_NAME = 'CRBS-API-deployment-group1'
  }
}