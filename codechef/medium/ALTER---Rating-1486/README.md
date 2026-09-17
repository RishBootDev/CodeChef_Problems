# ALTER - Rating 1486

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Alternating Work Days

Alice and Bob are two friends. Initially, the skill levels of them are zero. They work on alternative days, i.e one of Alice and Bob works on the odd-numbered days$(1, 3, 5, \dots)$ and the other works on the even-numbered days $(2, 4, 6, \dots)$. The skill levels of Alice and Bob increase by $A, B$ respectively on the days they work.

Determine if it is possible that the skill levels of Alice and Bob become exactly $P, Q$ respectively on some day.

### Input Format
- The first line contains an integer $T$, denoting the number of test cases. The $T$ test cases then follow:
- The first and only line of each test case contains four space-separated integers $A, B, P, Q$.
### Output Format

For each test case, print `YES` if it is possible that the skill levels of Alice and Bob become exactly $P, Q$ on some day, otherwise print `NO`.

You may print each character of the string in uppercase or lowercase (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).

### Constraints
- $1 \leq T \leq 10^3$
- $1 \leq A, B, P, Q \leq 10^9$
### Subtasks
- Subtask 1 (100 points): Original constraints
### Sample 1:
Input
Output

```
4
1 2 1 2
1 2 3 2
4 3 4 6
3 5 9 25

```

```
YES
NO
YES
NO

```

### Explanation:

 **Test Case $1$:**  Alice works on the first day and gains skill level $1$. Bob works on the second day and gains skill level $2$.

 **Test Case $2$:**  There is no possible way that the skill levels of Alice and Bob become $3$ and $2$ respectively.

 **Test Case $3$:**  Bob works on the first and third day and Alice works on the second day. Hence after the third day, the skill levels of Alice and Bob become $1\cdot4 = 4$ and $2 \cdot 3 = 6$ respectively.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T09:54:20.635Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            if(p%a==0 && q%b==0 && Math.abs(p/a-q/b)<=1){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
	}
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ALTER)