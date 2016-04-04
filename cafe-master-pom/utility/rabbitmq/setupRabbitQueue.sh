#!/bin/bash

if [ $# -eq 0 ] ; then
	echo "Usage: $0 -u <username> -p <password> -h <vhost> -i <rabbitmq_sbin>"
	echo "-i is optional"
	echo "Example for vhost /bfpb, notice it need to start with slash"
	exit 1
fi

while [ $# -gt 1 ] ; do
	case $1 in
        -i) sbin=$2     ; shift 2 ;;
		-u) username=$2 ; shift 2 ;;
		-p) password=$2 ; shift 2 ;;
		-h) vhost=$2    ; shift 2 ;;
		*) shift 1 ;;
	esac
done

if [ -n $sbin ] ; then
    export PATH=$sbin:$PATH
fi

echo "================================================="
echo "RabbitMQ sbin : $sbin"
echo "Username      : $username"
echo "Password      : $password"
echo "Vhost         : $vhost"
echo "================================================="

if [ -z $username ] || [ -z $password ] || [ -z $vhost ] ; then
	echo "Wrong parameters !!!!"
	echo "Usage: $0 -u <username> -p <password> -h <vhost> -i <rabbitmq_sbin>"
	echo "-i is optional"
	echo "Example for vhost /bfpb, notice it need to start with slash"
	exit 1
fi

echo "Dropping vhost and user"
rabbitmqctl delete_vhost $vhost
rabbitmqctl delete_user $username

echo "Creating vhost, user and set permission"
rabbitmqctl add_vhost $vhost
rabbitmqctl add_user $username $password
rabbitmqctl set_user_tags $username administrator
rabbitmqctl set_permissions -p $vhost $username ".*" ".*" ".*"

echo "Enable Admin Console"
rabbitmq-plugins enable rabbitmq_management
