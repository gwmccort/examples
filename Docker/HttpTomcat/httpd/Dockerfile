FROM ubuntu

ENV DEBIAN_FRONTEND noninteractive

# need for rc firewall, upper case doesn't work???
#ENV http_proxy http://proxy:9090
#ENV https_proxy https://proxy:9090

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
      apache2 \
      libapache2-mod-jk 
#    && rm -rf /var/lib/apt/lists/*

VOLUME ["/var/log/apache2"]
EXPOSE 80 443

ENTRYPOINT ["apache2ctl", "-D", "FOREGROUND"]
