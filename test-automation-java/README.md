# Test Automation Framework (Java)

## 📌 Overview

This project is a personal automation framework built using Java for both UI and API testing.

The goal was to create a clean, maintainable, and practical automation setup focused on realistic testing scenarios rather than unnecessary complexity or over-engineering.

The framework currently includes:

- UI automation with Selenium
- API automation with RestAssured
- Stateful business flow testing
- Allure reporting and reusable utilities

The focus was intentionally placed on:
- readability,
- maintainability,
- reusable flows,
- and practical automation design.

---

## 🧱 Project Structure

```text
com.branko
 ├── ui
 │    ├── base          # Base classes (BaseTest, BasePage)
 │    ├── config        # Configuration handling
 │    ├── driver        # Driver setup & management
 │    ├── enums         # Enums (WaitStrategy, etc.)
 │    ├── pom           # Page Object classes
 │    ├── tests         # UI test classes
 │    └── utils         # Assertions, waits, Allure helpers
 │
 ├── api
 │    ├── cart          # Cart API flows & validations
 │    ├── core          # Request helpers & API assertions
 │    ├── login         # Authentication flows
 │    ├── payment       # Payment flows & request models
 │    ├── products      # Product-related API flows
 │    ├── users         # User/account validations
 │    └── tests         # API test classes
 │
 └── shared             # Shared utilities & reporting helpers
```

---

## 🚀 Implemented Features

### UI Automation (Selenium + TestNG)

- Page Object Model (POM)
- Fluent test design
- Explicit wait abstraction
- Custom assertions (hard + soft)
- Screenshot capture on failure
- Allure step reporting
- Test grouping (smoke / regression)

### API Automation (RestAssured)

- Reusable API client structure
- Authentication testing
- Product validation
- Related product validation
- Cart lifecycle testing
- Payment method validation
- End-to-end order flow
- Stateful API business flow chaining
- Dynamic test data handling
- Reusable API assertions
- Request/response validation
- Request/response Allure reporting
- Sensitive data masking in reports

### Hybrid UI/API (planned)

- API-driven UI state setup
- Combined UI/API business flows
- Reduced UI setup dependencies
- Faster and more stable end-to-end scenarios

---

## ⚙️ Configuration

1. Copy example config:

```text
config.example.properties → config.properties
```

2. Update local values:

```properties
# Browser
browser=chrome
headless=false

# UI
baseUrl=https://www.saucedemo.com
username=your_username
password=your_password

# API
baseUrlPracticeTestingApi=https://api.practicesoftwaretesting.com
practiceSoftwareUsername=your_email
practiceSoftwarePassword=your_password
practiceSoftwareAdminUsername=admin_email

# Debug logging
debugMode=false
```

> `config.properties` is ignored by Git and should not be committed.

---

## ▶️ Running Tests

Run all tests:

```bash
mvn test
```

Run UI smoke tests:

```bash
mvn test -Dgroups=smoke
```

Run UI regression tests:

```bash
mvn test -Dgroups=regression
```

Run API smoke tests:

```bash
mvn test -Dgroups=smoke-api
```

Run API regression tests:

```bash
mvn test -Dgroups=regression-api
```

---

## 📊 Allure Reporting

Generate and open Allure report:

```bash
mvn test
allure serve target/allure-results
```

The framework includes:

- Structured step reporting
- Request payload attachments
- Response body attachments
- Screenshot capture on failure
- Debug request/response logging
- Sensitive data masking

---

## 🧪 Current Test Coverage

### UI

- Login flows
- Checkout flow
- Product/cart interactions

### API

- Authentication (positive & negative scenarios)
- Product validation
- Related product validation
- Cart lifecycle testing
- Payment method validation
- End-to-end order flow
- Stateful business flow chaining

---

## 🧠 Design Principles

The framework is intentionally kept simple and practical, focusing on:

- Readability
- Maintainability
- Reusable business flows
- Realistic automation scenarios
- Minimal but useful abstractions

The goal was to avoid unnecessary framework complexity while still creating a scalable and production-minded automation setup.

---

## 🔮 Next Steps

- Implement hybrid UI/API scenarios
- Add GitHub Actions CI pipeline

---

## 👤 Author

Branko Milovanovic
