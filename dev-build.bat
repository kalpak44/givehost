docker build -t give-host .
docker tag give-host kalpak44/give-host:latest
docker-compose pull && docker-compose up --detach --build
