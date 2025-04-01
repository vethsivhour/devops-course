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
            emailext (
                subject: "Pipeline Success: ${currentBuild.fullDisplayName}",
                body: "Build completed successfully. Check the build at: ${env.BUILD_URL}",
                to: 'vethsivhour@gmail.com',
                attachLog: true
            )
        }
        failure {
            echo 'Pipeline failed! Check the logs for details.'
            emailext (
                subject: "Pipeline Failed: ${currentBuild.fullDisplayName}",
                body: "Build failed. Check the build at: ${env.BUILD_URL}",
                to: 'vethsivhour@gmail.com',
                attachLog: true
            )
        }
        always {
            cleanWs()
        }
    }
}