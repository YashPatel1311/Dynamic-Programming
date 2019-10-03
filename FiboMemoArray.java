import java.math.BigInteger;
import java.util.*;

public class FiboMemoArray{

    int[][] memo;
    int[] counter;

    void initialize(int[] n,BigInteger size){
    
        memo=new int[size.intValue()][];
        memo[0][0]=1;

        if()

}


public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter any number  ");
String s=sc.nextLine();

/*
int[] n=new int[s.length()];

for(int i=0;i<s.length();++i){
    n[i]=(int)s.charAt(i);
}
*/

BigInteger size=new BigInteger(s);

System.out.println();

fiboMemo r1=new fiboMemo();

long start=System.nanoTime();
r1.initialize(n);
BigInteger result=r1.fibonacci(n);
long end =System.nanoTime();


System.out.println(n+" th fibonacci number is : "+result);
System.out.println("Time taken : "+(end-start)+" ns");

}
}
