def call() {

    sh '''
       trivy fs . -o trivy-resuly.json
    '''

}
