def call(String email, String status) {

    if (status == 'SUCCESS') {
        success(email)
    } else {
        failed(email)
    }

}

def success(String email) {

    emailext(
        to: email,
        subject: "SUCCESS : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        mimeType: 'text/html',
        attachmentsPattern: '''
reports/*.json,
reports/*.html,
dependency-check-report.*
''',
        body: """
<h2 style="color:green;">Build Successful</h2>

<b>Job:</b> ${env.JOB_NAME}<br>
<b>Build:</b> #${env.BUILD_NUMBER}<br>
<b>Result:</b> ${currentBuild.currentResult}<br>
<b>URL:</b><br>

<a href="${env.BUILD_URL}">
${env.BUILD_URL}
</a>
"""
    )

}

def failed(String email) {

    emailext(
        to: email,
        subject: "FAILED : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        mimeType: 'text/html',
        attachmentsPattern: '''
reports/*.json,
reports/*.html,
dependency-check-report.*
''',
        body: """
<h2 style="color:red;">Build Failed</h2>

<b>Job:</b> ${env.JOB_NAME}<br>
<b>Build:</b> #${env.BUILD_NUMBER}<br>
<b>Result:</b> ${currentBuild.currentResult}<br>
<b>URL:</b><br>

<a href="${env.BUILD_URL}">
${env.BUILD_URL}
</a>
"""
    )

}
