# swagger-demo
swagger-demo



# api-gateway-pattern


# Route for BOOK-SERVICE
spring.cloud.gateway.routes[0].id=BOOK-SERVICE
spring.cloud.gateway.routes[0].uri=http://localhost:9091
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/**
//http://localhost:8085/api/books

# Route for FILE-SERVICE
spring.cloud.gateway.routes[1].id=FILE-SERVICE
spring.cloud.gateway.routes[1].uri=http://localhost:8091
spring.cloud.gateway.routes[1].predicates[0]=Header=File,Service
//http://localhost:8085/files/upload

====== the above works fine =============

but if both apis having same common phrase ("/api")
within their route path like below:
http://localhost:8085/api/books
http://localhost:8085/api/files/upload
then conflict arises, 
only 1 works at a time



hence changed the controller end-point accordingly from 
http://localhost:8085/api/files/upload

to 

http://localhost:8085/files/upload
