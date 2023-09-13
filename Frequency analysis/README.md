# Word Frequency Analysis

This Java program, `WordFrequencyAnalysis`, is designed to analyze the frequency of words in a given text and display the words along with their respective frequencies in descending order. It uses a HashMap to store word frequencies and a HashMap to associate frequencies with lists of words.

## Usage

To use this program, follow these steps:

1. Compile the Java code using a Java compiler:
   ```
   javac Main.java
   ```

2. Run the compiled program:
   ```
   java Main
   ```

3. Enter your input when prompted. The line should contain the words separated by spaces.

4. After entering the input, the program will display the words along with their frequencies in descending order.

## Code Explanation

Here's a brief explanation of how the code works:

1. **Input**: The program first reads the input, which consists of the total number of words and a space-separated list of words.

2. **Data Structures**:
   - `map`: This is a `HashMap` that stores word frequencies.
   - `freqToWords`: This is a `HashMap` that associates frequencies with lists of words.

3. **Initialization**: The program initializes `map` by adding all the words from the input with an initial frequency of 0.

4. **Calculating Frequencies**: It then calculates the frequencies of words by iterating through the list of words and updating the corresponding values in the `map`.

5. **Initializing `freqToWords`**: Another loop initializes `freqToWords` by creating an empty `TreeSet` for each frequency.

6. **Associating Frequencies with Words**: The program associates each word with its frequency by adding the word to the corresponding `TreeSet` in `freqToWords`.

7. **Sorting**: It then sorts the frequencies in descending order.

8. **Output**: Finally, the program prints the words and their frequencies, starting with the most frequent words.

## Example

Here's an example of how to use the program:

```
Input:
5
apple banana cherry apple banana

Output:
apple 2
banana 2
cherry 1
```

In this example, the program counts the frequency of each word and displays them in descending order along with their frequencies.
