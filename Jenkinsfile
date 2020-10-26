pipeline {
	agent any
	stages{
		   stage ('Build') {
				steps {
					sh 'mvn clean package'
				}
		   }
		   stage ('Deploy') {
				steps {
					echo "Deploy step..."
				}
		   }
	}
} 
