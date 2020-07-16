# Consumer
- cd consumer
- ./mvnw clean compile package
- docker build -t ibm-cloud-academy/consumer:v1 .

# Producer
- cd producer
- ./mvnw clean compile package
- docker build -t ibm-cloud-academy/producer:v1 .

# Compose
 - docker-compose up -d