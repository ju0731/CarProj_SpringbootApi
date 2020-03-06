#!/bin/bash
export PATH=/home/ec2-user/apache-maven-3.6.3/bin:$PATH
if [ -d "/home/ec2-user/back" ]
then
    rm -rf /home/ec2-user/back
fi