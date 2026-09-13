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
