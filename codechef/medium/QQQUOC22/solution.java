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