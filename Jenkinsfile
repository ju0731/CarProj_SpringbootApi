pipeline {
  agent any
  stages {
    stage('Git cloning') {
      steps {
        git(url: 'https://github.com/bsp-incubation/booking-api.git', branch: 'master', credentialsId: 'woodchuckchoi')
      }
    }

    stage('Bulid') {
      steps {
        sh '''cd booking-api
sudo ./mvnw clean package'''
      }
    }

  }
}