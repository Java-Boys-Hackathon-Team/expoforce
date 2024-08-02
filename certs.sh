#!/usr/bin/env bash

sudo apt update
sudo apt install certbot
sudo certbot certonly --standalone -d expo-force.kuramshin-dev.ru
sudo certbot certonly --standalone -d pgadmin2.kuramshin-dev.ru
sudo certbot certonly --standalone -d minio2.kuramshin-dev.ru
sudo certbot certonly --standalone -d expo-force.ru