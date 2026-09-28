# Spring Microservices SaveData BD H2 in memory

This repository contains a **practical example of building microservices using Java Spring**. It is designed for learners and developers who want to understand and implement microservices architecture with Spring Boot.

## Features

* Demonstrates microservices architecture in Java Spring.
* Includes multiple services communicating via REST APIs.
* Uses **Spring Boot** for easy setup.
* Provides practical exercises to strengthen your understanding of microservices.

## Getting Started

### Prerequisites

* Java 21
* Maven

### Running the Application

1. Clone the repository:

```bash
git clone https://github.com/esauev/savedata-ms.git
cd savedata-ms
```

2. Build the services:

```bash
mvn clean install
```

3. Run each service individually (or use Docker Compose):

#### Option 1: Run individual services

```bash
cd service-name
mvn spring-boot:run
```

#### Option 2: Run all services using Docker Compose

```bash
docker-compose up
```

4. Access the services via their REST endpoints (check each service configuration for ports and endpoints).

## Tutorial
