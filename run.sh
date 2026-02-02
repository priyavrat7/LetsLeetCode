#!/bin/bash

# Smart run script: detects file type and runs C++ or Java accordingly

FILE="$1"

if [[ -z "$FILE" ]]; then
    echo "Error: No file provided"
    exit 1
fi

# Get file extension
EXT="${FILE##*.}"

case "$EXT" in
    cpp)
        echo "Running C++ file: $FILE"
        BINARY="/tmp/$(basename "$FILE" .cpp)"
        g++ -std=c++17 -Wall -Wextra -o "$BINARY" "$FILE"
        if [ $? -eq 0 ]; then
            "$BINARY"
        else
            echo "Compilation failed"
            exit 1
        fi
        ;;
    java)
        echo "Running Java file: $FILE"
        # Compile the Java file
        javac "$FILE"
        if [ $? -eq 0 ]; then
            # Extract class name from file
            CLASS_NAME="${FILE##*/}"
            CLASS_NAME="${CLASS_NAME%.java}"
            # Run from the directory containing the file
            DIR="$(dirname "$FILE")"
            cd "$DIR" || exit 1
            java "$CLASS_NAME"
        else
            echo "Compilation failed"
            exit 1
        fi
        ;;
    py)
        echo "Running Python file: $FILE"
        python3 "$FILE"
        ;;
    *)
        echo "Error: Unsupported file type '.$EXT'"
        exit 1
        ;;
esac
