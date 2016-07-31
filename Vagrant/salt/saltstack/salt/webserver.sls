# httpd:
#   pkg:
#     - installed

## doesn't work on rh need to rename apache 2 httpd
# apache:
#   pkg.installed: []
#   service.running:
#     - name: httpd
#     - require:
#       - pkg: apache

# https://docs.saltstack.com/en/latest/topics/tutorials/starting_states.html
httpd:
  pkg.installed: []
  service.running:
    - require:
      - pkg: httpd

# add default web page
/var/www/html/index.html:                   # ID declaration
  file:                                     # state declaration
    - managed                               # function
    - source: salt://webserver/index.html   # function arg
    - require:                              # requisite declaration
      - pkg: httpd                         # requisite reference

# install open jdk
java-1.8.0-openjdk.x86_64:
  pkg:
    - installed

# install tomcat
tomcat:
  pkg:
    - installed

# # install tomcat from tgzy
# tomcat:
#   archive:
#       - extracted
#       - name: /opt/
#       - source: http://mirror.metrocast.net/apache/tomcat/tomcat-7/v7.0.70/bin/apache-tomcat-7.0.70.tar.gz
#       - source_hash: md5=a551502b9f963e58e84d973216185e70
#       - archive_format: tar
#       - tar_options: z
#       - if_missing: /opt/apache-tomcat-7.0.70
