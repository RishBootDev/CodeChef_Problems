import java.util.*;
import java.lang.*;
import java.io.*;

class CodeChef{
    	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0 ){
		    
		    int n = sc.nextInt();
            
            int sum = n * ( n + 1 ) /2;
            
            if( (sum&1) == 0 ){
                System.out.println( n );
            }
            else{
                System.out.println( n - 1 );
            }
		    
		}
	}
}