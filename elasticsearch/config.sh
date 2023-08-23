#!/bin/sh

# docker pull docker.elastic.co/elasticsearch/elasticsearch:8.9.1
# wget https://artifacts.elastic.co/cosign.pub 
# cosign verify --key cosign.pub docker.elastic.co/elasticsearch/elasticsearch:8.9.1 
docker run --name es01 -p 9200:9200 -e "discovery.type=single-node" -it docker.elastic.co/elasticsearch/elasticsearch:8.9.1
