# inditex-prices-service

Technical challenge for Inditex position

## Uso

### Levantar servicio con Java -jar

    mvn clean package
    
    cd target/
    
    java -jar technical-proof-inditex-0.0.1-SNAPSHOT.jar --spring.profiles.active=local

### Levantar servicio con Docker

    docker build -t inditex-prices-service .
    
    docker run -p 8090:8090 -p 8082:8082 inditex-prices-service --spring.profiles.active=local


## Tecnologías usadas

* Java 21
* Spring Boot 2.6.3
* OpenApi
* Mapstruct
* Junit 5
* Docker
* PMD
* Checkstyle
* Flyway
* H2
* Spring Cache

## Patrones usados

La prueba técnica usa la arquitectura hexagonal para preservar el desacoplamiento entre las capas de infraestructura y las capas de dominio. Toda la lógica de negocio se encuentra bajo el paquete com.inditex.prices.application mientras que el código de infraestructura, ya sea para recibir peticiones del exterior o para hacerlas, se encuentra bajo el paquete com.inditex.prices.infrastructure.  

