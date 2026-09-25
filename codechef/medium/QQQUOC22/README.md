# QQQUOC22

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Equal Sum Swaps

You are given two warehouses, `A` and `B`, each containing crates with certain weights.
Find all pairs of crates one from `A` and one from `B`, that can be swapped so both warehouses end up with the same total weight.
Print all valid pairs where each pair is written as `a`, `b`, first list pairs with `even product` then list pairs with `odd product` and if no pair is found print `-1`

### Input Format
- The first line contains space-separated integers representing the weights of crates in warehouse A.
- The second line contains space-separated integers representing the weights of crates in warehouse B.
### Output Format
- A single line containing the numbers from the qualifying pairs, separated by commas.
- If no such pair exists, print -1.
### Constraints

$1\leq$ |A|,|B| $\leq10^5$

### Sample 1:
Input
Output

```
8 7
4 3
```

```
8,4,7,3
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T05:09:01.432Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) return;
        String[] aStr = sc.nextLine().trim().split("\\s+");
        String[] bStr = sc.nextLine().trim().split("\\s+");

        int sumA = 0, sumB = 0;
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (String s : aStr) {
            int val = Integer.parseInt(s);
            sumA += val;
            A.add(val);
        }

        for (String s : bStr) {
            int val = Integer.parseInt(s);
            sumB += val;
            B.add(val);
        }

        int diff = sumA - sumB;
        if (diff % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int target = diff / 2;
        Set<Integer> setB = new HashSet<>(B);

        List<String> evenPairs = new ArrayList<>();
        List<String> oddPairs = new ArrayList<>();

        for (int a : A) {
            int b = a - target;
            if (setB.contains(b)) {
                String pair = a + "," + b;
                if ((long) a * b % 2 == 0) {
                    evenPairs.add(pair);
                } else {
                    oddPairs.add(pair);
                }
            }
        }

        List<String> allPairs = new ArrayList<>();
        allPairs.addAll(evenPairs);
        allPairs.addAll(oddPairs);

        if (allPairs.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(String.join(",", allPairs));
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/QQQUOC22)