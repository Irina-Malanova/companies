FROM quay.io/wildfly/wildfly
ADD target/companies-1.0-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/