# SUMTRIAN - Rating 869

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Sums in a Triangle

Given an integer $N$, let us consider a triangle of numbers of $N$ lines in which a number $a_{11}$ appears in the first line, two numbers $a_{21}$ and $a_{22}$ appear in the second line, three numbers $a_{31}$, $a_{32}$ and $a_{33}$ appear in the third line, etc. In general, $i$ numbers $a_{i1}, a_{i2} \dots a_{ii}$ appear in the $i^{th}$ line for all $1 \leq i \leq N$. Develop a program that will compute the largest of the sums of numbers that appear on the paths starting from the top towards the base, so that:

- on each path the next number is located on the row below, more precisely either directly below or below and one place to the right.

 **Warning:**  large Input/Output data, be careful with certain languages

### Input Format
- The first line of the input contains an integer $T$, the number of test cases.
- Then T test cases follow. Each test case starts with an integer $N$, the number of rows. Then $N$ lines follow where in $i^{th}$ line contains $i$ integers $a_{i1}, a_{i2} \dots a_{ii}$.
### Output Format

For each test case print the maximum path sum in a separate line.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \lt 100$
- $0 \leq a_{ij} \lt 100$
### Sample 1:
Input
Output

```
2
3
1
2 1
1 2 3
4
1
1 2
4 1 2
2 3 1 1

```

```
5
9
```

### Explanation:

 **Test case 1:** 

There are a total of $4$ paths

- $(1,1) \rightarrow (2, 1) \rightarrow (3, 1)$ with sum equal to $4$.
- $(1,1) \rightarrow (2, 1) \rightarrow (3, 2)$ with sum equal to $5$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 2)$ with sum equal to $4$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 3)$ with sum equal to $5$.

Therefore, the maximum sum over all paths is equal to $5$.

 **Test case 2:** 

There are a total of $8$ paths

- $(1,1) \rightarrow (2, 1) \rightarrow (3, 1) \rightarrow (4, 1)$ with sum equal to $8$.
- $(1,1) \rightarrow (2, 1) \rightarrow (3, 1) \rightarrow (4, 2)$ with sum equal to $9$.
- $(1,1) \rightarrow (2, 1) \rightarrow (3, 2) \rightarrow (4, 2)$ with sum equal to $6$.
- $(1,1) \rightarrow (2, 1) \rightarrow (3, 2) \rightarrow (4, 3)$ with sum equal to $4$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 2) \rightarrow (4, 2)$ with sum equal to $7$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 2) \rightarrow (4, 3)$ with sum equal to $5$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 3) \rightarrow (4, 3)$ with sum equal to $6$.
- $(1,1) \rightarrow (2, 2) \rightarrow (3, 3) \rightarrow (4, 4)$ with sum equal to $6$.

Therefore, the maximum sum over all paths is equal to $9$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T10:50:43.852Z  

```java
import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (int it = 0; it < t; it++) {
            solve(scanner);
        }
        scanner.close();
    }

    public static void solve(Scanner scanner) {
        long n = scanner.nextLong();
        long[][] ar = new long[(int) n + 1][(int) n + 1];

        // Reading the input for the triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ar[i][j] = scanner.nextLong();
            }
        }

        long[][] dp = new long[(int) n + 1][(int) n + 1];

        for (int j = 1; j <= n; j++) {
            dp[(int) n][j] = ar[(int) n][j];
        }

        for (int i = (int) n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = ar[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[1][1]);
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/SUMTRIAN)