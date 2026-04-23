pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('JMeter Test') {
            steps {
                bat 'jmeter -n -t login_api_test.jmx -l results.jtl'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
