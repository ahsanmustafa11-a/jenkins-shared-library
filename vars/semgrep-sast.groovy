def call() {

    sh '''

        mkdir -p reports

        semgrep scan \
        --json \
        --output reports/semgrep-report.json \
        . || true

    '''

}
