FROM jenkins:1.651.3
USER root
RUN apt-get update
RUN apt-get install -y apt-transport-https ca-certificates
RUN echo 'deb https://apt.dockerproject.org/repo debian-jessie main' > /etc/apt/sources.list.d/docker.list
RUN apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
RUN apt-get update && apt-get install -y docker-engine
RUN gpasswd -a jenkins docker
RUN curl -L https://github.com/docker/compose/releases/download/1.8.0/run.sh > /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose

USER jenkins
COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY 00_matrix.groovy /usr/share/jenkins/ref/init.groovy.d/00_matrix.groovy
COPY 01_creds.groovy /usr/share/jenkins/ref/init.groovy.d/01_creds.groovy
COPY 02_envvars.groovy /usr/share/jenkins/ref/init.groovy.d/02_envvars.groovy
COPY 03_slave.groovy /usr/share/jenkins/ref/init.groovy.d/03_slave.groovy 


RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
