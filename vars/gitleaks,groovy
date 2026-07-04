def call() {

    sh '''

        mkdir -p reports

        gitleaks detect \
        --report-format json \
        --report-path reports/gitleaks-report.json || true

    '''

}
