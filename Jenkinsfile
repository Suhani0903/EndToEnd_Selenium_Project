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
                bat '''
                if exist report rmdir /s /q report
                if exist results.jtl del results.jtl
                jmeter -n -t "src\\test\\resources\\jmeter\\data\\httpbin_test_plan.jmx" -l results.jtl -e -o report
                '''
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }

        stage('Publish JMeter Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'report',
                    reportFiles: 'index.html',
                    reportName: 'JMeter Report'
                ])
            }
        }
    }
}
