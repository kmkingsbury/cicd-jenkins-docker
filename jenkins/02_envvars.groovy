import jenkins.model.*
import hudson.model.*
import hudson.slaves.*

String node_name = "master"
String env_key = "AA"
String env_value = "BB"


instance = Jenkins.getInstance()
if (node_name == "master") {
  node = instance
} else {
  instance.getNode(node_name)
}
props = node.nodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

if(props.empty) {
  def entry = new EnvironmentVariablesNodeProperty.Entry(env_key, env_value)
  def evnp = new EnvironmentVariablesNodeProperty(entry)
  node.nodeProperties.add(evnp)
} else {
  for (prop in props) {
    prop.envVars.put(env_key, env_value)
  }
}

instance.save()
