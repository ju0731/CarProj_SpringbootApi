#!/bin/bash
sudo mv /home/ec2-user/back/scripts/devops_back.service /etc/systemd/system/
sudo systemctl daemon-reload