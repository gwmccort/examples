# image that uses fortune as input to docker cowsay example

# start with whalesay image
FROM docker/whalesay:latest

# need for rc firewall, upper case doesn't work???
#ENV HTTP_PROXY http://proxy:9090
#ENV HTTPS_PROXY https://proxy:9090
ENV http_proxy http://proxy:9090
ENV https_proxy https://proxy:9090

# add fortunes command
RUN apt-get -y update && apt-get install -y fortunes

# run cowsay w/ fortune as input
CMD /usr/games/fortune -a | cowsay
