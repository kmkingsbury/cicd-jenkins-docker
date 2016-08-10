import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

instance = Jenkins.getInstance()
globalNodeProperties = instance.getGlobalNodeProperties()
envVarsNodePropertyList = globalNodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

newEnvVarsNodeProperty = null
envVars = null

if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
  newEnvVarsNodeProperty = new hudson.slaves.EnvironmentVariablesNodeProperty();
  globalNodeProperties.add(newEnvVarsNodeProperty)
  envVars = newEnvVarsNodeProperty.getEnvVars()
} else {
  envVars = envVarsNodePropertyList.get(0).getEnvVars()

}

def env_var_map = [
  'DO_WS_CLEANUP':'true',
  'DOCKER_CERT_PATH':'/var/jenkins_home/keys',
  'DOCKER_HOST':'tcp://10.0.0.1:443',
  'DOCKER_TLS_VERIFY':'1',
  'DTR_HOST':'10.0.0.2',
  'DTR_ORG':'orgname',
  'DTR_PREFIX':'10.0.0.2/',
  'NEXUS_USER':'admin',
  'STARTING_PATH':'/var/jenkins_home',
  'UCP_HOST':'10.0.0.1'
]

for (e in env_var_map)
      {
          envVars.put("${e.key}", "${e.value}")
	  println("Adding: ${e.key} => ${e.value}")
      }

instance.save()
