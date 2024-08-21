#!/bin/bash

# Print message before compilation
echo "Compiling Java files..."

# Compile Java files
javac -d bin src/com/greentube/exercise/reelsetbuilder/*.java src/com/greentube/exercise/reelsetbuilder/impl/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
else
    echo "Compilation failed."
    exit 1  # Exit the script with an error code
fi

# Print message before running the program
echo "Running the program..."

# Run the main class
java -cp bin com.greentube.exercise.reelsetbuilder.Main

# Print message after the program finishes
echo "Program finished running."
