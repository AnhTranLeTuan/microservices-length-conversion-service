# Length Conversion Service for Cloud-Based Microservices with DevOps and Automation

## Description
A part of the cloud-based microservices with DevOps and automation project that include:
* Set up this microservice for port 8100
* Create LengthExchangeProxy class to enable FeignClient that establish communication with the length exchange microservice
* Utilize the Eureka service registry to detect length exchange microservice without requiring a port number
* Build Controller that maps URL requests to specific functions, and retrieves information from URL to appropriate call the length exchange service's URL to retrieve data for further processing 
* Used FeignClient and RestTemplate for more options to allow communication between microservices
* Register this microservice for the Eureka service registry at port 8761
* Set up Micrometer and OpenTelemetry to allow the Zipkin server to monitor and manage this microservice's metrics, logs, and traces
