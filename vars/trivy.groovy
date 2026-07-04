def call() {

    sh '''

        mkdir -p reports

        trivy fs . \
        --format json \
        -o reports/trivy-report.json || true

    '''

}


# ==========================================
# If you want to Scan the image then Use these:
# trivy image \
# --format json \
# -o reports/trivy-image.json \
# image-name
# ==========================================
