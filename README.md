# 🚀 Spring Boot ECR ECS Fargate Demo

## 🎥 Demo Video

[Watch the demo](https://drive.google.com/file/d/1pChuY7mTEyJGMzxxCR7fQBzdgK4Rn1IO/view?usp=sharing)

The video shows the Docker image in Amazon ECR, the running ECS Fargate task, its public IP, and the live application in the browser.

> The app is not kept running all the time, to save AWS credits. The demo video shows it running on AWS.

---

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
* AWS CLI

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

## ⚙️ Application Endpoints

| Endpoint | Description |
|---|---|
| `GET /` | Styled landing page: "Hello from AWS ECS!" |
| `GET /health` | Returns `Application Healthy` |

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
docker build -t springboot-ecs-demo:v2 .
```

### Run Container Locally

```bash
docker run -d -p 8080:8080 --name springboot-ecs-demo-container springboot-ecs-demo:v2
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
docker tag springboot-ecs-demo:v2 <ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com/springboot-ecs-demo:v2
```

### Push Image

```bash
docker push <ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com/springboot-ecs-demo:v2
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

## 🔁 Updating the Application

1. Change the code and rebuild the JAR with Maven.
2. Build a new Docker image with a new tag (for example `v2`).
3. Push the new image to Amazon ECR.
4. Create a new task definition revision that uses the new image tag.
5. Update the ECS service to use the new revision.
6. Open the new public IP of the running task on port 8080.

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
* Task Definitions and Revisions
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
* Released a new version by pushing a new image and updating the ECS service.
* Exposed the application using a public IP.
* Understood the complete container deployment lifecycle on AWS.

---

## 👨‍💻 Author

Sai Abhiram