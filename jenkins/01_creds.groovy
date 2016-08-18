
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.plugins.sshslaves.*;

domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

/*
privateKey = new BasicSSHUserPrivateKey(
CredentialsScope.GLOBAL,
"jenkins-slave-key",
"root",
new BasicSSHUserPrivateKey.UsersPrivateKeySource(),
"",
""
)
*/

usernameAndPassword = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "gitlab", "Gitlab Password Configuration",
  "root",
  "password"
)

usernameAndPassword2 = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "nexus", "Nexus Password Configuration",
  "admin",
  "admin123"
)

//store.addCredentials(domain, privateKey)
store.addCredentials(domain, usernameAndPassword)
store.addCredentials(domain, usernameAndPassword2)

