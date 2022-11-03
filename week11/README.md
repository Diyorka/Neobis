# How to run using Dockerfile

1. Go to the path of week11 on terminal
2. Build an image: `docker build -t myrestapp .`
3. Set data: `docker run --name mysql -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=MyShop -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_PASSWORD=1234 -d mysql:latest`
4. Run the project: `docker run -d -p 8080:8080 --name myrestapp --link localhost:mysql myrestapp`
5. Make sure that project was started correctly: `docker logs myrestapp --follow`

# How to run using Docker-compose
1. Go to the path of week11
2. Up docker compose: `docker-compose up`


