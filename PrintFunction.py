
# HackerRank: Print Function

Solved the HackerRank Print Function problem in Python.

## What I Did
- Read an integer `n` from standard input.
- Used a `for` loop to iterate from `1` to `n`.
- Used `print(i, end="")` to print the numbers consecutively without spaces.
- Practiced loops, ranges, and controlling print output.

## Example
Input:
3

Output:
123

## Concepts Practiced
- `input()`
- `int()`
- `for` loops
- `range()`
- `print()` with `end=""`

# Read the integer from input
n = int(input())

# Loop from 1 through n
for i in range(1, n + 1):
    # Print each number without spaces or a new line
    print(i, end="")
