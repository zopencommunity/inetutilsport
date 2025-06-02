node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/inetutilsport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/inetutilsport.git'), string(name: 'PORT_DESCRIPTION', value: 'Inetutils is a collection of common network programs.' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
