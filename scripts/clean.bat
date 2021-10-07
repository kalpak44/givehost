FOR /f "tokens=*" %%i IN ('docker ps -qa') DO docker stop %%i
FOR /f "tokens=*" %%i IN ('docker ps -qa') DO docker rm %%i
FOR /f "tokens=*" %%i IN ('docker images -qa') DO docker rmi %%i