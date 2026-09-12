# ZCO14004

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### IPL
## Zonal Computing Olympiad 2014, 30 Nov 2013

In IPL 2025, the amount that each player is paid varies from match to match. The match fee depends on the quality of opposition, the venue etc.

The match fees for each match in the new season have been announced in advance. Each team has to enforce a mandatory rotation policy so that no player ever plays three matches in a row during the season.

Nikhil is the captain and chooses the team for each match. He wants to allocate a playing schedule for himself to maximize his earnings through match fees during the season.

### Input format

Line 1: A single integer  *N*, the number of games in the IPL season.

Line 2:  *N*  non-negative integers, where the integer in position  *i*  represents the fee for match  *i*.

### Output format

The output consists of a single non-negative integer, the maximum amount of money that Nikhil can earn during this IPL season.

### Test data

There is only one subtask worth 100 marks. In all inputs:

• 1 ≤  *N*  ≤ 2×105

• The fee for each match is between 0 and 104, inclusive.

### Live evaluation data

There are 12 test inputs on the server during the exam.

### Sample 1:
Input
Output

```
5 
10 3 5 7 3 
```

```
23
```

### Explanation:

Explanation: 10+3+7+3

### Sample 2:
Input
Output

```
8
3 2 3 2 3 5 1 3
```

```
17
```

### Explanation:

Explanation: 3+3+3+5+3

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T10:57:28.663Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static final long MOD = 1000000007; 
    static final long INF = 1000000000000000000L; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); 

        int[] fees = new int[n]; 
        for (int i = 0; i < n; i++) {
            fees[i] = scanner.nextInt(); // Read each fee
        }
        if (n == 1) {
            System.out.println(fees[0]);
            return;
        }
        if (n == 2) {
            System.out.println(fees[0] + fees[1]);
            return;
        }

        int[][] dp = new int[n][3];
        dp[0][1] = dp[0][2] = fees[0]; 
        dp[1][0] = fees[0];
        dp[1][1] = fees[1];
        dp[1][2] = fees[0] + fees[1];

        for (int i = 2; i < n; i++) {
          
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            
            dp[i][1] = fees[i] + dp[i - 1][0];
           
            dp[i][2] = fees[i] + fees[i - 1] + dp[i - 2][0];
        }

        System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
        

    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/ZCO14004)