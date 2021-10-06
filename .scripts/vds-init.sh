#!/bin/bash
if ! command -v docker &> /dev/null
    docker --version
then
    rm -rf /var/lib/apt/lists/*
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu
    $(lsb_release -cs) edge"
    apt-get update && apt-get -y -o Dpkg::Options::="--force-confnew" install docker-ce
    echo "docker could not be found"

fi
systemctl start docker
systemctl start docker-compose