pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials-id')
        DOCKERHUB_USERNAME = 'brayansantiagodev'
        IMAGE_BOOKS = "${DOCKERHUB_USERNAME}/ms-books"
        IMAGE_LOANS = "${DOCKERHUB_USERNAME}/ms-loans"
        IMAGE_TAG = "v${env.BUILD_NUMBER}"
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Clonando el repositorio...'
                checkout scm
            }
        }

        stage('Build Maven') {
            steps {
                echo 'Compilando microservicios...'
                dir('ms-books') {
                    sh 'chmod +x ./mvnw'
                    sh './mvnw clean package -DskipTests'
                }
                dir('ms-loans') {
                    sh 'chmod +x ./mvnw'
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                echo 'Construyendo imágenes de Docker...'
                dir('ms-books') {
                    sh "docker build -t ${IMAGE_BOOKS}:latest -t ${IMAGE_BOOKS}:${IMAGE_TAG} ."
                }
                dir('ms-loans') {
                    sh "docker build -t ${IMAGE_LOANS}:latest -t ${IMAGE_LOANS}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Push to Registry') {
            steps {
                echo 'Subiendo imágenes a DockerHub...'
                sh "echo \$DOCKERHUB_CREDENTIALS_PSW | docker login -u \$DOCKERHUB_CREDENTIALS_USR --password-stdin"
                sh "docker push ${IMAGE_BOOKS}:latest"
                sh "docker push ${IMAGE_BOOKS}:${IMAGE_TAG}"
                sh "docker push ${IMAGE_LOANS}:latest"
                sh "docker push ${IMAGE_LOANS}:${IMAGE_TAG}"
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado. Limpiando...'
            sh "docker logout"
        }
        success {
            echo 'Pipeline ejecutado con éxito.'
        }
        failure {
            echo 'El pipeline falló.'
        }
    }
}
