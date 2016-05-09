# ubuntu based hello world
FROM ubuntu:15.04
MAINTAINER gwmccort@gmail.com

# for rc proxy
ENV http_proxy http://proxy:9090
ENV https_proxy https://proxy:9090

RUN apt-get update
CMD ["echo", "Hello World"]
