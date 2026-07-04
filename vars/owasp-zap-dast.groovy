def call(String url) {

    sh """
        docker run --rm \
        zaproxy/zap-stable \
        zap-baseline.py \
        -t ${url}
    """

}
