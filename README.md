# Swag Labs PFM Project Using Java, Selenium, TestNG and Allure Report Generates

This repository contains an automation testing framework using the Page Factory Model (PFM) design pattern with TestNG and Allure reporting for Swag Labs (https://www.saucedemo.com/). Follow the setup instructions below to get started.

## 📁 Clone the Repository

```bash
git clone https://github.com/farhadcu/PFM_FM.git
```

## ⚙️ Environment Setup

### 1. Install Required Tools

- **Eclipse IDE**  
  Download and install from: https://www.eclipse.org/downloads/

- **Java JDK**  
  Install and configure Java JDK (version 21.0.6 LTS or later). Ensure the `JAVA_HOME` environment variable is set correctly.

- **TestNG Plugin for Eclipse**  
  Install from the Eclipse Marketplace:  
  `Help` > `Eclipse Marketplace` > Search for **TestNG** and install.

### 2. Configure Allure Reporting

#### a. Install Apache Maven

1. Download the **binary zip archive**:  
   [apache-maven-3.9.9-bin.zip](https://maven.apache.org/download.cgi)
2. Extract the zip file (e.g., to `C:\apache-maven-3.9.9`)
3. Add the Maven `bin` folder to your system `PATH`:  
   `C:\apache-maven-3.9.9\bin`

#### b. Install Allure Command-Line Tool

1. Download the **Allure CLI zip**:  
   [allure-2.33.0.zip](https://github.com/allure-framework/allure2/releases/tag/2.33.0)  
   Documentation: [Install Allure for Windows](https://allurereport.org/docs/install-for-windows/)
2. Extract the zip file (e.g., to `C:\allure-2.33.0`)
3. Add the Allure `bin` folder to your system `PATH`:  
   `C:\allure-2.33.0\bin`

### ✅ Verify Installation

Run the following commands in `cmd` to verify installation:

```bash
mvn -v
allure --version
```

## 📦 Import Project into Eclipse

1. Open Eclipse
2. Go to `File` > `Import` > `Maven` > `Existing Maven Projects`
3. Select the cloned project folder
4. Click **Finish**
5. Right-click the project > `Maven` > `Update Project`
   - Enable **Force Update of Snapshots/Releases**
   - Click **OK**

## 📂 Project Structure

```
src/
└── test/
    ├── java/
    │   ├── environment/       # Basic settings and WebDriver setup
    │   ├── pages/             # Page Object classes
    │   └── execution/         # Test execution entry point
```

## 🚀 Running Tests

To execute the automation tests:

1. Navigate to:  
   `src/test/java/execution/TestExecution.java`
2. Right-click on the file > `Run As` > `TestNG Test`

## 📊 Generating Allure Reports

1. After test execution is complete, open the project root directory in `cmd`
2. Run the following command:

```bash
allure serve
```

This will launch a browser window displaying the Allure report.

---

Thank you for your patience!
