# Test Automation (Java)

## 📌 Overview

This project is a personal test automation setup built using Java.  
It covers both UI and API testing, with the goal of keeping the structure clean, readable, and easy to extend.

The focus was not on adding too many features, but on building a solid and maintainable foundation.

---

## 🧱 Project Structure

```
com.branko
 ├── ui
 │    ├── base        # Base classes (BaseTest, BasePage)
 │    ├── config      # Configuration handling
 │    ├── driver      # Driver setup & management
 │    ├── enums       # Enums (WaitStrategy, etc.)
 │    ├── pom         # Page Object classes
 │    ├── tests       # UI test classes
 │    └── utils       # Assertions, waits, Allure helpers
 │
 ├── api
 │    ├── client      # API client / request handling
 │    ├── tests       # API test classes
 │    └── utils       # API helpers (if needed)
```

---

## 🚀 What’s implemented

### UI (Selenium + TestNG)

- Page Object Model (POM)
- Fluent test design
- Custom assertions (hard + soft)
- Explicit wait abstraction
- Allure step reporting
- Screenshot on failure
- Test grouping (smoke / regression)

### API (RestAssured)

*(to be added / in progress)*

- RestAssured-based API tests
- Request/response validation
- Reusable client structure

---

## ⚙️ Configuration

1. Copy example config:

```
config.example.properties → config.properties
```

2. Update local values:

```
browser=chrome
headless=false
baseUrl=https://www.saucedemo.com

# Use credentials from https://www.saucedemo.com/
username=your_username
password=your_password
```

> `config.properties` is ignored by Git and should not be committed.

---

## ▶️ Running tests

Run all tests:

```
mvn test
```

Run specific group:

```
mvn test -Dgroups=smoke
```

```
mvn test -Dgroups=regression
```

---

## 📊 Allure report

```
mvn test
allure serve target/allure-results
```

---

## 🧪 Current test coverage

- Login (positive & negative)
- End-to-end order flow
- Checkout validation
- Inventory state changes (add/remove product)

---

## 🧠 Notes

The project is intentionally kept simple to focus on clarity and good structure rather than over-engineering.

The API layer is planned to follow the same principles as the UI part (clean structure, reusable components, readable tests).

---

## 🔮 Next steps

- Implement API tests (RestAssured)
- Add integration scenarios (UI + API combined)
- Optional CI setup (GitHub Actions)

---

## 👤 Author

Branko Milovanovic
