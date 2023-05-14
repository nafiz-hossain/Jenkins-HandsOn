pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        sh '''

            cd ~/TigerIT/projects/communicator-desktop-pwa/



            branchName="dev"
            environment="local'"
            gitChange="reset"
            iOSUser="yes"


            #Print the splitted words
            echo "App Name : $appName"
            echo "Branch Name : $branchName"
            echo "Environment : $environment"
            echo "Update Npm (yes/no) : $updateNpm"
            echo "Git change (stash/reset) : $gitChange"
            echo "iOS user (yes/no) : $iOSUser"







            if [ "$gitChange" = "stash" ]; then
                        git stash
                        git fetch
            	    git checkout $branchName
            	    git pull origin $branchName
            	    git stash pop
            fi

            if [ "$gitChange" = "reset" ]; then
                git reset --hard
                git fetch
                git checkout $branchName
                git pull origin $branchName
            fi
        '''
      }
    }

        stage ('Dependency Installation'){

        steps{
        sh '''
            updateNpm="no"
            appName="commchat-agent"

            #npm install on condition
            if [ "$updateNpm" = "yes" ]; then
                npm i

            fi
            cd electron/
            if [ "$updateNpm" = "yes" ]; then
                npm i
            fi
        '''
    }
    }

    stage ('Build'){

        steps{
        sh '''
        cd ~/TigerIT/projects/communicator-desktop-pwa/electron/
        ionic serve -c=staging
        npx cap sync @capacitor-community/electron
        cd electron/

        if [ "$appName" = "commchat" ]; then
        npm run electron:build-linux
        fi

        if [ "$appName" = "agent" ]; then
        npm run electron:build-linux-agent
        fi


        '''
    }
    }


  }
}
