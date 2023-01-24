node {
    # comment
    stage('Jar build') {
        sh "${env.WORKSPACE}/mvnw -Dmaven.test.skip=true clean package"
    }

    stage('Docker image build') {
        sh "cd ${env.WORKSPACE}"
        sh "sudo docker build -t ${env.JOB_NAME} ."
    }
    
    stage('Docker container stop/remove') {
        sh "sudo docker stop ${env.JOB_NAME}"
        sh "sudo docker rm ${env.JOB_NAME}"
    }
    
    stage('Docker container run') {
        sh "sudo docker run -d --cap-add=SYS_PTRACE -e JAVA_OPTS='-Xms1g -Xmx1g' --name ${env.JOB_NAME} -p 8080:8080 ${env.JOB_NAME}"
    }
}
