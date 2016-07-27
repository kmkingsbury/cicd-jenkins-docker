import jenkins.*

import jenkins.model.*

import hudson.*

import hudson.model.*

import jenkins.model.Jenkins
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.slaves.NodeProperty


nodes = Jenkins.getInstance().getGlobalNodeProperties()
def props = nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
for (prop in props) {
    prop.envVars.put("TEST_ENV", "WORKS")
}

