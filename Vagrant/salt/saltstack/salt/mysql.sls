Install mysql and make sure the mysql service is running:
  pkg.installed:
    - name: mysql
#  service.running:
#    - name: mysql