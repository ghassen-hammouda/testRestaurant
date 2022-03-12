pipeline {
    
     	  

    environment {
 	 registry = "ghassenhammouda/restaurant"
 	 registryCredential = 'dockerHubId'
 	 dockerImage = ''
 } 

    
    agent any
     
    stages {
        stage('Getting Project from Git') {
            steps {
                echo 'Project is downloading...'
                 git branch:'main', url:'https://github.com/ghassen-hammouda/testRestaurant.git'

            }
        }
        
         stage('cleaning the project') {
            steps {
                echo 'Cleaning Project...'
                 bat 'mvn clean'

            }
        }
        
          stage('artifact construction') {
            steps {
                echo 'artifact construction...'
                 bat 'mvn package -Dmaven.test.skip=true  -P test-coverage'

            }
        }
    
        stage('Unit Tests') {
            steps {
                echo 'launching Unit Tests...'
                 bat 'mvn test'

            }
        }
       
          /*      stage('Preparing the Static Tests : Jacoco') {
            steps {
                echo "In order to prepare our static tests, let's configure code coverage (Jacocco)"
                bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
                bat 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent clean install'
            }
        }*/

       
       
        stage('Static Tests : SonarQube') {
            steps {
                echo 'Launching Static Tests...'
                bat 'mvn sonar:sonar'

            }
        }
        stage('Deploying Project : Nexus') {
            steps {
                echo 'Our project is deploying on nexus...'
               bat ' mvn deploy:deploy-file -DgroupId=tn.esprit.asi -DartifactId=testRestaurant -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/  -Dfile=target/testRestaurant-1.0.jar'
            }
            /* post {
                failure {
                    mail bcc: '',
                    body: '''Hello, We would like to inform you that Nexus was not able to deploy project!''',
                    cc: '',
                    from: '',
                    replyTo: '',
                    subject: '[Deploying Project : Nexus] Failed to build',
                    to: 'ghassen.hammouda@esprit.tn'
                }
            }*/
        }
        
      stage('Building our image') {
 			steps {
 				script {
 				    DOCKER_BUILDKIT=0
 				    dockerImage = docker.build registry + ":$BUILD_NUMBER"

 					echo 'Building our Docker Image ghassenhammouda/restaurant...'
                	bat 'docker build -t ghassenhammouda/restaurant .'

 				
 			}
 		
 		}
      }
 		stage('Deploy our image') {
 			steps {
 				script {
 					docker.withRegistry( '', registryCredential) {
 					dockerImage.push()
 					}
 				}
 			}
 		
 		}

        
           

        
        
    }
}

