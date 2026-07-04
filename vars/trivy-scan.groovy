def call() {

    sh '''

        mkdir -p reports

        trivy fs . \
        --format json \
        -o reports/trivy-report.json || true

    '''

}
