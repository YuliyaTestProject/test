pipeline {
	agent any
	stages{
		   stage ('Build') {
				steps {
					bat "mvn clean package"
				}
		   }
		   stage ('Deploy') {
				steps {
					echo "Deploy step..."
				}
		   }
	}
} 
