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

    stage('Create DG') {
      steps {
        sh '''aws deploy delete-deployment-group \\
    --application-name Devops_back \\
    --deployment-group-name $DG_NAME
aws deploy create-deployment-group \\
    --application-name Devops_back \\
    --deployment-group-name $DG_NAME \\
    --service-role-arn arn:aws:iam::144149479695:role/landingproject_codeDeploy_codeDeploy \\
    --auto-scaling-groups $ASG \\
    --deployment-style deploymentType="BLUE_GREEN",deploymentOption="WITH_TRAFFIC_CONTROL" \\
    --blue-green-deployment-configuration terminateBlueInstancesOnDeploymentSuccess={action="TERMINATE"},deploymentReadyOption={actionOnTimeout=CONTINUE_DEPLOYMENT},greenFleetProvisioningOption={action=COPY_AUTO_SCALING_GROUP} \\
    --load-balancer-info targetGroupInfoList={name=$TARGET_GROUP} \\
    --deployment-config-name CodeDeployDefault.AllAtOnce
'''
      }
    }

    stage('Create Deployment') {
      steps {
        sh '''aws deploy create-deployment \\
    --application-name Devops_back \\
    --deployment-config-name CodeDeployDefault.AllAtOnce \\
    --deployment-group-name $DG_NAME \\
    --s3-location bundleType="tar",bucket="landingproject",key=back.tar \\
    --file-exists-behavior "OVERWRITE"'''
      }
    }

  }
  environment {
    DG_NAME = 'something'
    ASG = 'something'
    TARGET_GROUP = 'something'
  }
}