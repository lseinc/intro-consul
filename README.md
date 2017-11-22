# Introduction to Spring Cloud Consul


# examples
### 01-setup
  Instructions to setup consul and start service.  
  - The docker folder has some examples of running a consul instance container.  
  - The local folder has a scripts to download the consul binary (consul-binary-download.sh) and then just unzip and run it with the other script (consul-start-local.sh) 

--

### 02-example-service
  This example has a demo-consul-service that uses a property (config/application/special.name) that we can set to a value like "COJUG Rocks" in the consul ui key/value section
  - The service is based off Spring Boot 2.0.0M5 and Spring Cloud Consul Configuration and Spring Cloud Consul Discovery and Spring Actuator dependencies
  - To create a similar project use [https://start.spring.io](https://start.spring.io) InitializR site.
  - If starting from scratch, add @EnableDiscoverClient (turn on registering the service to consul) to the Demo Application java file where @SpringBootApplication is defined.
  - If starting from scratch, add a REST controller and include the @Configuration, @EnableAutoConfiguration, @RefreshScope , @RestController .
  - @RefreshScope is key to reloading properties from consul posting to Actuator's refresh endpoint 
  - Start the demo-consul-service using  <code>./mvnw spring-boot:run</code>  
  - GET [http://localhost:8080/hello](http://localhost:8080/hello) to see the hello world message to include the default @Value from special.name:
    Hello World! From not-yet-special !
  - Now change / create a key (config/application/specialname) / value (COJUG Rocks) in consul at [http://localhost:8500/ui](http://localhost:8500/ui)  
 - Or you can create the key / value using curl   <code>curl -X PUT -d "COJUG Rocks" http://localhost:8500/v1/kv/application/special.name</code>  
  - In order to refresh the properties in the service when they are changed in consul, one just needs to POST the refresh endpoint
  - Example using curl:  <code>curl -s -X POST http://localhost:8080/application/refresh -o-  </code>  
  - There is a script (refresh.sh) that can be used to execute the refresh POST.  

--

### 03-example-frontend  
  This example is from the point of view of an application looking up the service and making a call. The actual code base just delegates its work to the original demo-consul-service.
  - Assuming you cloned the 02 project or downloaded a new one from start.spring.io, create a REST controller like set 02 above.
  - Add to Demo Application java file the @EnableDiscoveryClient (register) and @EnableFeignClients (discovery for REST Template).
  - Add to example REST controller @Configuration, @EnableAutoConfiguration, @RefreshScope, @RestController


This will evole for the next presentation.
This is a work in progress.
Enjoy!  

--



