# QQQUOC24

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Palindrome Sum

You are given a number `N`. Your task is to find two special palindromic numbers:

- num1: the largest palindrome smaller than N.
- num2: the smallest palindrome greater than N. Once found calculate final_number = num1 + num2. If final_number is also a palindrome Print it and stop otherwise decrease N by 1 and repeat the process until a palindrome sum is found.
### Input Format

A single line of input contains an integer `N`.

### Output Format
- Print the palindrome final_number.
### Constraints

$1 ≤ N ≤ 10^4$

### Sample 1:
Input
Output

```
123
```

```
252
```

### Explanation:

Largest palindrome < 123 -> 121

Smallest palindrome > 123 -> 131

Sum = 252 -> palindrome

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T04:49:05.853Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (true) {
            int num1 = largestPalindromeLess(N);
            int num2 = smallestPalindromeGreater(N);
            int final_number = num1 + num2;
            if (isPalindrome(final_number)) {
                System.out.println(final_number);
                break;
            }
            N--;
        }
    }

    static int largestPalindromeLess(int N) {
        for (int i = N - 1; i >= 0; i--) {
            if (isPalindrome(i)) return i;
        }
        return 0;
    }

    static int smallestPalindromeGreater(int N) {
        int i = N + 1;
        while (true) {
            if (isPalindrome(i)) return i;
            i++;
        }
    }

    static boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/QQQUOC24)