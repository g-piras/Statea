FROM --platform=linux/amd64 ubuntu/apache2:2.4-22.04_beta
WORKDIR /root/myfolder
RUN apt update -y && \
apt upgrade -y && \
apt install git -y && \
apt install wget -y && \
apt install unzip -y && \
apt install iputils-ping -y && \
apt install iproute2 -y && \
apt install nano -y && \
apt install tree -y && \
# install Java
apt-get update && apt-get install java-common && \
wget https://corretto.aws/downloads/latest/amazon-corretto-17-x64-linux-jdk.deb && \
dpkg --install $(ls) && \
# enable Apache RewriteRules and Proxy
a2enmod rewrite && \
a2enmod proxy && \
a2enmod proxy_http && \
rm /etc/apache2/sites-enabled/000-default.conf
COPY 000-default.conf /etc/apache2/sites-enabled/
# clean-up
RUN rm -r ./* && \
apt autoremove -y
# create and switch user
RUN useradd -m spring
# USER spring