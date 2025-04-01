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
        
        stage('Code Quality') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }
        
        stage('Build and Test') {
            steps {
                sh 'mvn clean compile test'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
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
                    java -cp target/HelloWorldApp-1.0-SNAPSHOT.jar com.mycompany.app.App
                '''
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded! Application is ready.'
        }
        failure {
            echo 'Pipeline failed! Check the logs for details.'
        }
        always {
            cleanWs()
        }
    }
}