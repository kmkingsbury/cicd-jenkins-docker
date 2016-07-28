import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

import jenkins.model.Jenkins
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.slaves.NodeProperty

def env_var_map = [
  'DO_WS_CLEANUP':'true',
  'DOCKER_CERT_PATH':'/var/jenkins/keys',
  'DOCKER_HOST':'tcp://10.121.145.60:443',
  'DOCKER_TLS_VERIFY':'1',
  'STARTING_PATH':'/var/jenkins_home',
]


nodes = Jenkins.getInstance().getGlobalNodeProperties()
def props = nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
for (prop in props) {
  for (e in env_var_map)
      {
          prop.envVars.put("${e.key}", "${e.value}")
      }
}

/*
def slaves = hudson.model.Hudson.instance.getNodes()
//nodes = Jenkins.getInstance().getGlobalNodeProperties()
for (slave in slaves)
{
  //def props = nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
  def props = slave.nodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
  for (prop in props) {
      for (e in env_var_map)
      {
          prop.envVars.put("${e.key}", "${e.value}")
      }
  }
}

