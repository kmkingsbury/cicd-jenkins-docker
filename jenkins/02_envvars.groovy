import jenkins.*

import jenkins.model.*

import hudson.*

import hudson.model.*

import jenkins.model.Jenkins
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.slaves.NodeProperty


nodes = Jenkins.getInstance().getGlobalNodeProperties()
<<<<<<< Updated upstream
def props = nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
for (prop in props) {
    prop.envVars.put("TEST_ENV", "WORKS")
}

=======

//def props = nodes.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

def evnp = new EnvironmentVariablesNodeProperty();
for (prop in evnp) {
    prop.envVars.put("TEST_ENV", "WORKS")
}


/*
def slaves = hudson.model.Hudson.instance.getNodes()
for (slave in slaves) {
    println "-----------------------"
    println slave.name
    println "-----------------------"

    def props = slave.nodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
    for (prop in props) {
        prop.envVars.put("TEST_ENV", "WORKS")
    }
    //SAVE
}
*/
/*if ( nodes.size() != 1 ) {

 println("error: unexpected number of environment variable containers: "

          + nodes.size()

          + " expected: 1")

} else {

 envVars= nodes.get(0).getEnvVars()

  envVars.put("FOO", "foo")


  Jenkins.getInstance().save()

  println("okay")

}
*/


>>>>>>> Stashed changes
