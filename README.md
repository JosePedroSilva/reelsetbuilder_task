# Reel Set Builder

This Java application ...

## Getting Started

These instructions will help you get the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java Development Kit (JDK) installed. You can check by running `java -version` in your terminal.
* Bash shell (most Linux/macOS systems have this by default)

### Running the Application

There are two ways to run this application:

#### 1. Using the Convenience Script

This is the recommended way for most users.

1. Make the script executable:
   ```bash
   chmod +x run_and_compile.sh
   ```

2. Run the script:
   ```bash
   ./run_and_compile.sh
   ```

#### 2. Running manually
Alternatively, you can manually compile and run the application as follows:

Navigate to the src directory:

```bash
cd src/
javac -d ../bin src/com/greentube/exercise/reelsetbuilder/*.java src/com/greentube/exercise/reelsetbuilder/impl/*.java
cd ../bin/
java -cp . com.greentube.exercise.reelsetbuilder.Main
```

