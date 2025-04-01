pipeline {
    agent any
    
    tools {
        jdk 'JDK 21'
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/vethsivhour/devops-course'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        
        stage('Run') {
            steps {
                sh 'java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.HelloWorldApp'
            }
        }
    }
}