pipeline {
	agent any
	stages{
		   stage ('Build') {
				steps {
					mvn clean package
				}
		   }
		   stage ('Deploy') {
				steps {
					echo "Deploy step..."
				}
		   }
	}
} 
