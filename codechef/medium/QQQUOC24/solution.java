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
