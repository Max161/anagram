## Anagram Program
This program takes two strings as input and determines whether they are anagrams of each other.

## Installation
To use this program, you must have Java and Maven installed on your computer. You can download Java and Maven from the respective official website.

Once Java is installed, you can download the Anagram program by cloning this repository:

```sh
git clone https://github.com/Max161/anagram.git
```

## Usage
To run the program, navigate to the directory where the code is located and run the following command:

```sh
mvn clean install
java -jar ./target/anagram-1.0.jar text1 text2
```
Replace text1 and text2 with the two strings you want to compare. The program will output whether the two strings are anagrams of each other.

For example:

```sh
java -jar ./target/anagram-1.0.jar text1 text2 "rail safety" "fairy tales"
```
### Output:
Congratulations the words are anagrams!
This program was inspired by the Anagram problem on LeetCode.