@echo off

rem from:http://stackoverflow.com/questions/32639765/how-do-i-create-a-docker-machine-with-a-specific-url-using-docker-machine-and-vi

setlocal enabledelayedexpansion
set machine=%1
if "%machine%" == "" (
    echo dmvbf expects a machine name
    exit /b 1
)
set ipx=%2
if "%ipx%" == "" (
    echo dmvbf x missing ^(for 192.168.x.y^)
    exit /b 2
)
set ipy=%3
if "%ipy%" == "" (
    echo dmvbf y missing ^(for 192.168.x.y^)
    exit /b 3
)

echo kill $(more /var/run/udhcpc.eth1.pid) | docker-machine ssh %machine% sudo tee /var/lib/boot2docker/bootsync.sh >NUL
echo ifconfig eth1 192.168.%ipx%.%ipy% netmask 255.255.255.0 broadcast 192.168.%ipx%.255 up | docker-machine ssh %machine% sudo tee -a /var/lib/boot2docker/bootsync.sh >NUL

docker-machine ssh %machine% "sudo cat /var/run/udhcpc.eth1.pid | xargs sudo kill"

docker-machine ssh %machine% "sudo ifconfig eth1 192.168.%ipx%.%ipy% netmask 255.255.255.0 broadcast 192.168.%ipx%.255 up"
