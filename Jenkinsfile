pipeline {
    agent any
    
    environment {
        PHP_VERSION = '8.2'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Install Dependencies') {
            steps {
                sh 'composer install'
            }
        }
        
        stage('Copy Environment File') {
            steps {
                sh 'cp .env.example .env'
                sh 'php artisan key:generate'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'php artisan test'
            }
        }
        
        stage('Deploy') {
            steps {
                sh 'php artisan config:cache'
                sh 'php artisan route:cache'
                sh 'php artisan view:cache'
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}