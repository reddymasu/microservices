                                              Video Streaming Microservices

This project demonstrates a video streaming application using a microservices architecture. It consists of two main microservices:

1.Movie Catalog Service: Manages all video details such as ID, name, description, and file path.

2.Movie Streaming Service: Streams videos by ID, using service communication to retrieve video details from the Movie Catalog Service.

Project Architecture

The project is structured into the following microservices:

    1.Movie Catalog Service:
        Manages video metadata in the database.
        Provides REST API endpoints to retrieve video details.
        Stores data such as video ID, name, description, and file path.
        
    2.Movie Streaming Service:
        Streams video content based on the video ID.
        Communicates with the Movie Catalog Service using RestTemplate to fetch video metadata.
        Retrieves the file path from the catalog service to stream the video content.
        
    3.Configuration Server
        Centralized management of configuration properties for all microservices.
        Provides a single location to manage environment-specific properties.
        
    4.Service Registry (Eureka Server):
        Registers all microservices and manages their discovery.
        Enables inter-service communication without hard-coded URLs.
        
    5.Zipkin Server:
        Distributed tracing to monitor and visualize microservice interactions.
        Tracks the flow of requests across all microservices, providing performance insights and error diagnosis.
        
Prerequisites

    Java 8 or above
    Spring Boot 3.0 or above
    Maven 3.6 or above
    MySQL
    Eureka Server
    Zipkin Server
    Configuration repository (e.g., Spring Cloud Config)

Getting Started
Clone the Repository

        git clone https://github.com/reddymasu/microservices.git
        cd microservices

Setting Up Configuration Server

1.Start the Configuration Server to manage all microservice configurations.    
2.Ensure all configuration files are placed in the config repository.

Setting Up Service Registry  
1.Start the Eureka Server.  
2.Ensure all microservices are registered with Eureka for service discovery.

Running the Microservices

1.Movie Catalog Service:
Run the MovieCatalogServiceApplication.java file to start the Movie Catalog Service.
This service will expose REST endpoints for video metadata management.

2.Movie Streaming Service:
Run the MovieStreamingServiceApplication.java file to start the Movie Streaming Service.
This service will handle video streaming requests using the video ID.

Running Zipkin Server  
1.Start the Zipkin Server to enable tracing across all microservices.  
2.Access the Zipkin dashboard at http://localhost:9411 to visualize service traces.  

API Endpoints

Movie Catalog Service  
Get Video Details by ID:  
            @GetMapping("/movie-info/list")  
Response: JSON object containing videos metadata such as name, description, and file path.  

Movie Streaming Service  

Stream Video by ID  
          GetMapping("/stream/with-id/{videoInfoId}")  
Streams video content based on the provided video ID. 

@GetMapping("/stream/{videopath}")  
Streams video content based on the provided video path. 

Inter-Service Communication    
The Movie Streaming Service uses RestTemplate to communicate with the Movie Catalog Service.    
Service registry (Eureka) is used to discover and communicate between microservices dynamically.  

Distributed Tracing with Zipkin  
Zipkin is integrated to trace requests and visualize service interactions.    
Each request trace is available in the Zipkin dashboard, providing insights into request flow and latency.




    

