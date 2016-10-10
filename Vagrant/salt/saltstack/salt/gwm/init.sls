test managed file:
  file.managed:
    - name: /home/vagrant/hello.txt
    - source: salt://gwm/files/hello.txt

# install apache httpd
# https://docs.saltstack.com/en/latest/topics/tutorials/starting_states.html
httpd:
  pkg.installed: []
  service.running:
    - require:
      - pkg: httpd

# add a user
# https://docs.saltstack.com/en/latest/ref/states/all/salt.states.user.html
# fred:
#   user.present:
#     - fullname: Fred Jones
#     - shell: /bin/zsh
#     - home: /home/fred
#     - uid: 4000
#     - gid: 4000
#     - groups:
#       - wheel

# http://russell.ballestrini.net/understanding-salt-stack-user-and-group-management/
fred2:
  user:
    - present
