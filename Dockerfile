FROM jenkins:1.651.1
USER jenkins
COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY 00_matrix.groovy /usr/share/jenkins/ref/init.groovy.d/00_matrix.groovy
COPY 01_creds.groovy /usr/share/jenkins/ref/init.groovy.d/01_creds.groovy
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
