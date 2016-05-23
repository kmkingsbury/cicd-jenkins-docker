# cicd-jenkins-docker
Git repo for making Jenkins in a container for CICD testing/pipeline building


Running:
Test:
 ~/Library/Python/2.7/bin/jenkins-jobs --conf etc/jenkins_jobs.ini test jobs/project-example.yaml

 Update:
 ~/Library/Python/2.7/bin/jenkins-jobs --conf etc/jenkins_jobs.ini update jobs/project-example.yaml


Credentials:
http://stackoverflow.com/questions/32208763/update-jenkins-credentials-by-script

@todo
# enable security
# Make API user, get Credentials
# Make Credentials for Gitlab instance

Get API token for a user
```
user = hudson.model.User.get('username')
prop = user.getProperty(jenkins.security.ApiTokenProperty.class)
println(prop.getApiToken())
```
