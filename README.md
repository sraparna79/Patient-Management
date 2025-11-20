# Patient-Management

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](#)  
[![Version](https://img.shields.io/badge/version-0.1.0-blue.svg)](#)  
[![License](https://img.shields.io/badge/license-MIT-lightgrey.svg)](#)  

## What this project does  
**Patient-Management** is a micro-services-based system for managing patient data in a healthcare setup. It is composed of services such as `api-gateway`, `auth-service`, `patient-service`, `billing-services`, `analytics-service`, along with infrastructure and integration tests. :contentReference[oaicite:0]{index=0}  
The system provides endpoints to register, update, query, and manage patient records and billing/analytics workflows in a modular, scalable architecture.

## Why it’s useful  
### Key features  
- **Modular architecture** – each service is isolated (e.g., `patient-service`, `billing-services`, `auth-service`) so you can scale, test and deploy independently. 
- **API Gateway** – a front door for all services (via `api-gateway`) simplifying routing, authentication and observability.  
- **Authentication & authorization** – using the `auth-service`, the system supports secure access and service-to-service authentication.  
- **Billing and analytics workflows** – billing services and analytics service modules allow extended functionality beyond basic CRUD of patient records.  
- **Integration tests** – a dedicated `integration-tests` directory ensures end-to-end flows are validated. 
### Benefits  
- Enables healthcare organisations to manage patient data with clear separation of concerns, enabling maintainability and scalability.  
- Promotes best practices in micro-services (service isolation, gateway, integration tests).  
- Ready to extend: new services (e.g., appointment scheduling, reporting) can be added without major rewrites.

## How to get started  
### Prerequisites  

- Java 11+ (or preferred JDK version as per the services). Directly used from jetbrains.
- Docker and/or Kubernetes (if you opt for containerised setup)  
- A relational or NoSQL database (depending on each service configuration). Personally used PostgreSQL.  
- Git  

### Clone the repo  
```bash
git clone https://github.com/sraparna79/Patient-Management.git
cd Patient-Management


