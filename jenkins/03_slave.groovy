import jenkins.model.*
import hudson.model.*
import hudson.slaves.*
import hudson.plugins.sshslaves.*
import java.util.ArrayList;
import hudson.slaves.EnvironmentVariablesNodeProperty.Entry;

  List<Entry> env = new ArrayList<Entry>();
  env.add(new Entry("key1","value1"))
  env.add(new Entry("key2","value2"))
  EnvironmentVariablesNodeProperty envPro = new EnvironmentVariablesNodeProperty(env);
  Slave slave = new DumbSlave(
                    "agent-node","Agent node description",
                    "/home/jenkins",
                    "1",
                    Node.Mode.NORMAL,
                    "image-build",
                    new SSHLauncher("hostname",22,"ec2-user","","/var/jenkins_home/keys/key.pem","","","",""),

                    new RetentionStrategy.Always(),
                    new LinkedList())
  slave.getNodeProperties().add(envPro)
  Jenkins.instance.addNode(slave)

