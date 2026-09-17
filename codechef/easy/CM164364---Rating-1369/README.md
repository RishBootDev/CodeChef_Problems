# CM164364 - Rating 1369

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Chocolate Monger

There are $n$ chocolates, and you are given an array of $n$ numbers where the $i$-th number $A_i$ is the flavour type of the $i$-th chocolate. Sebrina wants to eat as many different types of chocolates as possible, but she also has to save at least $x$ number of chocolates for her little brother.

Find the maximum possible number of distinct flavour types Sebrina can have.

### Input Format

The first line contains an integer $T$ --- the number of test cases.

- The first line of each test case consists of two integers $n$, $x$ - The number of chocolates Sabrina has and the number of chocolates she has to save for her brother, respectively.
- The second line contains $n$ integers $A_1,\ldots, A_n$, where the $i$-th chocolate has type $A_i$.
### Output Format

For each test case, output a single integer denoting the maximum possible number of distinct chocolate flavours Sabrina can eat.

### Constraints
- $1\le T\le 10$
- $1 \le x \le n \le 2 \cdot 10^5$
- $1 \le A_{i} \le 10^9$
- Sum of $n$ over all test cases do not exceed $2 \cdot 10^5$
### Sample 1:
Input
Output

```
3
2 1
1 2
4 2
1 1 1 1
5 3
50 50 50 100 100
```

```
1
1
2
```

### Explanation:

 **Test case $1$:**  In the first case, the maximum number of chocolates Sebrina can have is $1$ as she has to leave $1$ chocolate for her brother. Thus, the maximum number of distinct chocolates is also $1$.

 **Test case $2$:**  Sebrina has to leave $2$ chocolates for her brother. She can eat any $2$ chocolates. Since all the chocolates have the same flavor, it does not matter which chocolates she eats. The maximum number of distinct chocolates would be $1$.

 **Test case $3$:**  Sebrina needs to save $3$ chocolates for her brother. She can eat any $2$ chocolates. To maximize the number of distinct chocolates, she can eat chocolates $1$ and $5$ with flavors $50$ and $100$ respectively. Thus maximum number of distinct chocolates is $2$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T07:30:49.364Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[a];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0)+ 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (k1, k2) -> map.get(k2) - map.get(k1)
            );
            for(int c : map.keySet()) {
                pq.add(c);
            }
            while(k -- > 0 && !pq.isEmpty()) {
                int temp = pq.poll();
                int value = map.get(temp);
                value--;
                if(value != 0) {
                    map.put(temp, value);
                    pq.add(temp);
                
                }else map.remove(temp);
            }
            System.out.println(map.size());

        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/CM164364)