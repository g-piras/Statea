FROM --platform=linux/amd64 ubuntu:rolling
WORKDIR /root/myfolder
ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=Europe/Rome
RUN apt update -y && \
apt upgrade -y && \
apt install git -y && \
apt install wget -y && \
apt install unzip -y && \
apt install iputils-ping -y && \
apt install iproute2 -y && \
apt install nano -y && \
apt install tree -y && \
apt install -y tzdata && \
# install Java
apt-get update && apt-get install java-common && \
wget https://corretto.aws/downloads/latest/amazon-corretto-17-x64-linux-jdk.deb && \
dpkg --install $(ls) && \
# clean-up
rm -r ./* && \
apt autoremove -y && \
# create and switch user
useradd -m spring
# USER spring
CMD ["tail", "-f", "/dev/null"]