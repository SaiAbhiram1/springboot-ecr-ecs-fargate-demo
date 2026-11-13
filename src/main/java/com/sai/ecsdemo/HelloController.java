package com.sai.ecsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/", produces = "text/html")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1">
              <title>Hello from AWS ECS</title>
              <style>
                * { box-sizing: border-box; }
                body {
                  margin: 0;
                  min-height: 100vh;
                  display: flex;
                  align-items: center;
                  justify-content: center;
                  font-family: 'Segoe UI', Arial, sans-serif;
                  color: white;
                  text-align: center;
                  background: linear-gradient(-45deg, #0f2027, #6a11cb, #2575fc, #ff3d77);
                  background-size: 400% 400%;
                  animation: move 12s ease infinite;
                }
                @keyframes move {
                  0% { background-position: 0% 50%; }
                  50% { background-position: 100% 50%; }
                  100% { background-position: 0% 50%; }
                }
                .card {
                  width: 90%;
                  max-width: 640px;
                  padding: 48px 36px;
                  border-radius: 24px;
                  background: rgba(255, 255, 255, 0.14);
                  border: 1px solid rgba(255, 255, 255, 0.3);
                  backdrop-filter: blur(14px);
                  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.35);
                }
                .badge {
                  display: inline-flex;
                  align-items: center;
                  gap: 8px;
                  padding: 6px 16px;
                  border-radius: 999px;
                  background: rgba(0, 0, 0, 0.3);
                  font-size: 14px;
                  letter-spacing: 1px;
                }
                .dot {
                  width: 10px;
                  height: 10px;
                  border-radius: 50%;
                  background: #3dff8a;
                  animation: pulse 1.5s infinite;
                }
                @keyframes pulse {
                  0% { box-shadow: 0 0 0 0 rgba(61, 255, 138, 0.8); }
                  100% { box-shadow: 0 0 0 12px rgba(61, 255, 138, 0); }
                }
                h1 { margin: 24px 0 10px; font-size: 44px; }
                p { margin: 0 0 28px; font-size: 18px; opacity: 0.9; }
                .tags { display: flex; flex-wrap: wrap; gap: 10px; justify-content: center; }
                .tag {
                  padding: 8px 18px;
                  border-radius: 999px;
                  background: rgba(255, 255, 255, 0.2);
                  font-size: 14px;
                  font-weight: 600;
                }
                .footer { margin-top: 32px; font-size: 13px; opacity: 0.75; }
              </style>
            </head>
            <body>
              <div class="card">
                <div class="badge"><span class="dot"></span>LIVE ON AWS</div>
                <h1>Hello from AWS ECS!</h1>
                <p>A Spring Boot application running in a Docker container, deployed on AWS Fargate.</p>
                <div class="tags">
                  <span class="tag">Java 17</span>
                  <span class="tag">Spring Boot</span>
                  <span class="tag">Docker</span>
                  <span class="tag">Amazon ECR</span>
                  <span class="tag">ECS Fargate</span>
                </div>
                <div class="footer">Built and deployed by Sai Abhiram</div>
              </div>
            </body>
            </html>
            """;
    }

    @GetMapping("/health")
    public String health() {
        return "Application Healthy";
    }
}