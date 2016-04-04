@echo off

setlocal

set username=%1
set password=%2
set vhost=%3
set sbin=%4

if "%1" == "" GOTO ERROR
if "%2" == "" GOTO ERROR
if "%3" == "" GOTO ERROR

set PATH=%sbin%;%PATH%

echo "Dropping vhost and user"
cmd /c rabbitmqctl delete_vhost %vhost%
cmd /c rabbitmqctl delete_user %username%

echo "Creating vhost, user and set permission"
cmd /c rabbitmqctl add_vhost %vhost%
cmd /c rabbitmqctl add_user %username% %password%
cmd /c rabbitmqctl set_user_tags %username% administrator
cmd /c rabbitmqctl set_permissions -p %vhost% %username% ".*" ".*" ".*"

echo "Enable Admin Console"
cmd /c rabbitmq-plugins enable rabbitmq_management

GOTO DONE

:ERROR
echo "Usage: <username> <password> <vhost> <sbin>"
echo "<sbin> is optional"
echo "Example for vhost /bfpb, notice it need to start with slash"
GOTO END

:DONE
echo "DONE.."

:END