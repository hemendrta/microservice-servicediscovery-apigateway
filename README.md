# microservice-servicediscovery-apigateway

We have 2 services:

1. Contact Service (contact-service)
2. User Service (user-service)

API Gateway:

API-Gateway (api-gateway)

Eureka Server:

Eureka Server (eureka-server)

Both the services are having the dependency for Eureka Client and whenever the service spins up the Eureka Server register both the services.

API Gateway helps in accessing both the services with a single port.
