# 🚀 Spring Boot ECR ECS Fargate Demo

## 📌 Project Overview

This project demonstrates how to containerize a Spring Boot application using Docker and deploy it on AWS using Amazon ECR, Amazon ECS, and AWS Fargate.

The application is built locally, packaged as a Docker image, pushed to Amazon ECR, and deployed as a serverless container using Amazon ECS Fargate.

---

## 🏗️ Architecture

```text
Local Machine
      ↓
Spring Boot Application
      ↓
Maven Build (.jar)
      ↓
Docker Image
      ↓
Amazon ECR
      ↓
Amazon ECS (Fargate)
      ↓
Public IP
      ↓
Web Browser
```

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Maven
* Docker
* Amazon ECR
* Amazon ECS
* AWS Fargate
* AWS IAM
* AWS VPC

---

## 📂 Project Structure

```text
springboot-ecr-ecs-fargate-demo
│
├── src/
├── target/
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## ⚙️ Application Endpoint

```http
GET /
```

### Sample Response

```text
Hello from AWS ECS!
```

---

## 🐳 Dockerization

### Build Application

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

### Build Docker Image

```bash
docker build -t springboot-ecs-demo:v1 .
```

### Run Container Locally

```bash
docker run -d -p 8080:8080 --name springboot-ecs-demo-container springboot-ecs-demo:v1
```

### Verify

```bash
docker ps
```

Access:

```text
http://localhost:8080
```

---

## 📦 Amazon ECR

### Create Repository

Repository Name:

```text
springboot-ecs-demo
```

### Authenticate Docker

```bash
aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin <ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com
```

### Tag Image

```bash
docker tag springboot-ecs-demo:v1 <ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com/springboot-ecs-demo:v1
```

### Push Image

```bash
docker push <ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com/springboot-ecs-demo:v1
```

---

## ☁️ Amazon ECS Deployment

### ECS Cluster

```text
springboot-ecs-demo-cluster-v2
```

### Launch Type

```text
AWS Fargate
```

### Task Definition

```text
springboot-ecs-demo-task
```

### Container Configuration

```text
Container Name : springboot-ecs-demo
Port           : 8080
Protocol       : TCP
```

### ECS Service

```text
springboot-ecs-demo-service
```

### Desired Tasks

```text
1
```

---

## 🔄 Deployment Workflow

```text
1. Develop Spring Boot Application
2. Build JAR using Maven
3. Create Docker Image
4. Test Container Locally
5. Push Image to Amazon ECR
6. Create ECS Cluster
7. Create Task Definition
8. Create ECS Service
9. Run Application on AWS Fargate
10. Access Application through Public IP
```

---

## 📚 Concepts Learned

### Amazon ECR

* Container Registry
* Image Storage
* Image Versioning

### Amazon ECS

* Clusters
* Task Definitions
* Services
* Deployments

### AWS Fargate

* Serverless Containers
* Automatic Infrastructure Management
* Scalable Container Execution

### Container Lifecycle

```text
Code
 ↓
Build
 ↓
Containerize
 ↓
Push
 ↓
Deploy
 ↓
Run
```

---

## 🎯 Learning Outcomes

* Built and packaged a Spring Boot application.
* Created and managed Docker containers.
* Stored Docker images in Amazon ECR.
* Created ECS clusters and task definitions.
* Deployed containers using AWS Fargate.
* Exposed the application using a public IP.
* Understood the complete container deployment lifecycle on AWS.

---

## 👨‍💻 Author

Sai Abhiram


