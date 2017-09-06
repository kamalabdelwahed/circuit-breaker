# circuit-breaker

Microservices Boot order:
1. Config Service
2. Discovery Service
3. Actor
4. Genre
5. Movie
6. Role
7. Gateway

Description of Microservices:
1. Config Service: Service to configure all apps to run on post 8888 (Netflix Config Server)
2. Discovery Service:  Netflix Eureka Server
3. Actor: Actor service
4. Genre: Genre service
5. Movie: Movie service
6. Role: Role service (Hystrix configuration here)
7. Gateway: Gateway service (single point access to all the microservices using gateway's port 8090)

Circuit Breaker Implementation:

# Interface classes:
1. /role/service/IMovieService (reaches out to Movie service for the movie details)
2. /role/service/IActorService (reaches out to Actor service for the actor details)

# Implementation classes (with Hystrix delegation):
1. /role/service/HystrixDelegatingIMovieServiceImpl 
2. /role/service/HystrixDelegatingIActorServiceImpl 

Use the following annotation above the method that may fail
	@HystrixCommand(fallbackMethod="fallback")
  
Note that the fallbackMathod (in case of failure) must be named exactly as set in the @HystrixCommand annotation
