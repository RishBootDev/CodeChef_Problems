# QQQUOC19

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Digit Alternator

You are given a string, `S` that is guaranteed to contain at least one special character, at least one even digit, and at least one odd digit. Your program must first count the number of special characters in the string.

- If the count of special characters is even, print all the even and odd digits from the string alternately, starting with the first even digit.
- If the count of special characters is odd, print all the even and odd digits from the string alternately, starting with the first odd digit.

After one of the groups of digits (even or odd) is exhausted, append the rest of the digits from the other group to the end.

### Input Format

A single line of input containing the string, `S`.

### Output Format

Print a single line containing the rearranged digits without any spaces.

### Constraints

$3\leq |S| \leq 10^6$

### Sample 1:
Input
Output

```
A5c67r21i@p#8t
```

```
652781
```

### Explanation:

The special characters are `@` and `#`. The count is 2, which is even.
Even digits are: 6, 2, 8.
Odd digits are: 5, 7, 1.
Since the count is even, we start with an even digit. The arrangement is: `6` (even), `5` (odd), `2` (even), `7` (odd), `8` (even), `1` (odd).
Result: `652781`

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-13T04:07:38.915Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();
        int specialCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (d % 2 == 0) even.add(c);
                else odd.add(c);
            } else if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        boolean startEven = (specialCount % 2 == 0);

        while (i < even.size() && j < odd.size()) {
            if (startEven) {
                result.append(even.get(i++));
                startEven = false;
            } else {
                result.append(odd.get(j++));
                startEven = true;
            }
        }

        while (i < even.size()) result.append(even.get(i++));
        while (j < odd.size()) result.append(odd.get(j++));

        System.out.println(result.toString());
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/QQQUOC19)