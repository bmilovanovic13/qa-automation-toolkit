# Test Automation Framework (Java)

## 📌 Overview

This project is a personal automation framework built using Java for both UI and API testing.

The goal was to create a clean, maintainable, and practical automation setup focused on realistic testing scenarios rather than unnecessary complexity or over-engineering.

The framework currently includes:

- UI automation with Selenium
- API automation with RestAssured
- Hybrid UI/API testing scenarios
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
├── api
│    ├── cart          # Cart API flows & validations
│    ├── core          # Request helpers & API assertions
│    ├── login         # Authentication flows
│    ├── payment       # Payment flows & request models
│    ├── products      # Product-related API flows
│    ├── users         # User/account validations
│    └── tests         # API test classes
│
├── hybrid
│    ├── HybridOrderFlowTest
│    └── HybridProductDetailsTest
│
├── shared
│    ├── AllureUtils
│    ├── AuthenticationHelper
│    └── Config
│
└── ui
     ├── base          # Base classes (BaseTest, BasePage)
     ├── driver        # Driver setup & management
     ├── enums         # Enums (WaitStrategy, etc.)
     ├── pom           # Page Object classes
     ├── tests         # UI test classes
     └── utils         # Assertions, waits, UI helpers
```

---

### Test Layers

The framework is organized into three primary testing layers:

- **UI** – End-to-end browser automation using Selenium
- **API** – Backend validation and business flow testing using RestAssured
- **Hybrid** – Combined API/UI scenarios leveraging API-driven state setup and UI validation

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

### Hybrid UI/API

Implemented hybrid scenarios:

- API authentication with JWT browser injection
- API-driven order flow execution
- API-driven product data verification in UI
- Cross-layer API/UI validation
- Reduced UI setup dependencies
- Faster and more stable end-to-end scenarios

---

## ⚙️ Configuration

1. Copy the example configuration:

```text
config.example.properties → config.properties
```

2. Update values if needed:

```properties
# Browser
browser=chrome
headless=false

# UI (SauceDemo)
baseUrl=https://www.saucedemo.com
username=standard_user
password=secret_sauce

# Practice Software Testing
baseUrlPracticeTesting=https://practicesoftwaretesting.com/
baseUrlPracticeTestingApi=https://api.practicesoftwaretesting.com

practiceSoftwareUsername=customer@practicesoftwaretesting.com
practiceSoftwarePassword=welcome01
practiceSoftwareAdminUsername=admin@practicesoftwaretesting.com

# Debug logging
debugMode=false
```

The provided credentials are public demo accounts intended for testing purposes and can be used out of the box.

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

Run hybrid smoke tests:

```bash
mvn test -Dgroups=smoke-hybrid
```

Run all hybrid tests:

```bash
mvn test -Dgroups=hybrid
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

### Hybrid UI/API

* JWT-based browser authentication
* API-driven order flow execution
* API-to-UI product verification
* Cross-layer validation between API and UI

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

- Expand hybrid UI/API scenario coverage
- Add GitHub Actions CI pipeline
- Improve reusable authentication and browser state handling
- Continue expanding realistic business flow coverage

---

## 👤 Author

Branko Milovanovic
