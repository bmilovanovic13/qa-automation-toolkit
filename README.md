# QA Automation Toolkit

## 📌 Overview

This repository represents a personal QA automation toolkit built to simulate realistic testing scenarios across multiple testing layers.

The goal of the project is not to create an over-engineered framework, but to build a practical and maintainable automation setup that reflects real-world QA engineering work.

The repository currently includes:

- UI automation
- API automation
- Hybrid UI/API testing
- Reusable automation utilities
- CI-ready project structure

The focus is intentionally placed on:

- readability,
- maintainability,
- reusable business flows,
- realistic automation scenarios,
- and practical engineering decisions.

The Java automation module is currently the primary and most actively developed part of the repository, while additional modules are planned for future expansion.

---

## 🧰 Projects Included

### 🔹 Java Automation (UI + API)

Tech stack:

- Java
- Selenium WebDriver
- TestNG
- Maven
- RestAssured
- Allure Reporting

Focus areas:

- UI automation
- API automation
- Business flow testing
- Stateful API flow chaining
- Hybrid UI/API testing testing
- Reusable automation utilities

Current coverage includes:

### UI

- Login flows
- Product/cart interactions
- Billing and checkout validation
- Order flow scenarios

### API

- Authentication testing
- Product validation
- Related product validation
- Cart lifecycle testing
- Payment method validation
- End-to-end order flow
- Request/response reporting
- Negative API scenarios

### Hybrid UI/API

Current coverage includes:

- JWT-based browser authentication
- API-driven order flow execution
- API-to-UI product verification
- Cross-layer validation between API and UI
- Reduced UI setup dependencies
- Faster and more stable end-to-end scenarios

👉 See: [test-automation-java](test-automation-java/README.md)

---

### 🔹 Playwright (Planned)

Planned tech stack:

- Playwright
- TypeScript / JavaScript

Planned focus areas:

- Modern UI automation
- Fast and reliable end-to-end flows
- Lightweight browser automation

> This module is planned for future expansion and will be used for exploring modern UI automation approaches alongside Selenium.

👉 See: [ui-automation-playwright](ui-automation-playwright/README.md)

---

### 🔹 k6 (Planned)

Planned tech stack:

- k6

Planned focus areas:

- API performance testing
- Load testing
- Basic stress testing scenarios

> This module is planned for future performance testing experiments and lightweight API load testing.

👉 See: [performance-testing-k6](performance-testing-k6/README.md)

---

## 🧠 Project Approach

This repository is intentionally structured as a toolkit rather than a single framework.

Each module is isolated and focused on a specific testing layer, while still being designed to work together when needed.

The main focus of the project is:

- Practical automation design
- Clean and maintainable structure
- Minimal but useful abstractions
- Reusable business flows
- Realistic testing scenarios
- CI-friendly organization

The goal is to avoid unnecessary complexity while still creating a scalable and production-minded automation setup.

---

## 📊 Reporting

The Java automation framework includes:

- Structured Allure step reporting
- Request/response attachments
- Response body logging
- Screenshot capture on failure
- Sensitive data masking
- Debug request/response logging

### 📸 Reporting Preview

Example reporting screenshots:

- [API Request/Response Reporting](docs/screenshots/api-request-response.png)
- [Cart Flow Reporting](docs/screenshots/api-cart-flow.png)
- [UI Order Flow Reporting](docs/screenshots/ui-order-flow.png)

---

## 🚀 Current Direction

The Java automation module is currently the most developed part of the repository and serves as the primary automation project.

Current work is focused on:

- Adding GitHub Actions CI pipelines

---

## ▶️ How to Use

Each project/module contains its own setup instructions and README documentation.

Refer to:

```text
test-automation-java/README.md
ui-automation-playwright/README.md
performance-testing-k6/README.md
```

---

## 🔮 Roadmap

- Explore modern UI automation with Playwright
- Add performance testing experiments with k6
- Continue expanding realistic business flow coverage

---

## 👤 Author

Branko Milovanovic