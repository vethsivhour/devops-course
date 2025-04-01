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
        
        stage('Build and Test') {
            steps {
                sh 'mvn clean compile test'
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        
        stage('Run') {
            steps {
                sh '''
                    echo "Listing target directory:"
                    ls -l target/
                    echo "Jar file content:"
                    jar tvf target/HelloWorldApp-1.0-SNAPSHOT.jar
                    echo "Running application:"
                    java -cp target/HelloWorldApp-1.0-SNAPSHOT.jar com.mycompany.app.HelloWorldApp
                '''
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}