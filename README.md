# QA Automation Toolkit

## 📌 Overview

This repository represents a QA automation toolkit designed to simulate a real-world testing environment.

It combines UI, API, and performance testing into a modular structure that can scale and integrate with CI pipelines.

The focus is not just on writing tests, but on building a maintainable and extensible automation architecture.

---

## 🧰 Projects included

### 🔹 Java Automation (UI + API)

Tech stack:
- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Reporting
- RestAssured *(planned)*

Covers:
- UI automation (login, checkout, validations)
- API automation *(in progress)*

👉 See: `test-automation-java`

---

### 🔹 Playwright (E2E)

Tech stack:
- Playwright
- TypeScript / JavaScript

Focus:
- Modern UI testing
- Fast and reliable E2E scenarios

👉 See: `ui-automation-playwright`

---

### 🔹 k6 (Performance)

Tech stack:
- k6

Focus:
- Load testing
- Performance validation
- API stress scenarios

👉 See: `performance-testing-k6`

---

## 🚧 Work in progress

This toolkit is being gradually expanded to cover:

- API automation (RestAssured)
- Modern UI testing (Playwright)
- Performance testing (k6)

The current focus is on building a solid UI automation foundation, with additional layers added step by step.

---

## 🧠 Approach

This toolkit is built with focus on:

- **Scalability** – easy to extend tests and add new layers
- **Separation of concerns** – UI, API, and performance layers are isolated but designed for integration
- **Maintainability** – clean structure, reusable components, minimal duplication
- **CI readiness** – supports fast smoke tests and full regression execution

---

## 🚀 How to use

Each module has its own setup and instructions.

Refer to individual project READMEs:

- `test-automation-java/README.md`
- `ui-automation-playwright/README.md`
- `performance-testing-k6/README.md`

---

## 🔮 Roadmap

- Complete API layer (RestAssured)
- Add integration scenarios (UI + API)
- Add CI (GitHub Actions)

---

## 👤 Author

Branko Milovanovic