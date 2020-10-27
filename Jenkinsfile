pipeline {
	agent any
	stages{
		   stage ('Build') {
				steps {
					bat "mvn clean"
				}
		   }
		   stage ('Deploy') {
				steps {
					echo "Deploy step..."
				}
		   }
	}
} 
