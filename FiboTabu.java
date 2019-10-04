import java.math.BigInteger;
import java.util.*;

public class FiboTabu{

  static  long count=0;    
    int[][] memo;
    int counter;
    int[] base;

    
    void initialize(int n){
        base=new int[1];
        base[0]=1;
       memo=new int[n][];
       counter=1;
       memo[0]=base;
        
        if(n>1){
        memo[1]=base;         
        counter=2;
    }
}

int[] Equal(int[]a,int[]b){

    int diff=a.length-b.length;

    int[] b2=new int[a.length];

    for(int i=diff;i<a.length;i++)
    b2[i]=b[i-diff];

     
    return b2;
 }

 

int[] Add(int[] a, int[]b)
{

    b=Equal(a, b);        

int[] result=new int[a.length+1];

    for(int i=result.length-1;i>=1;i--){
        result[i]+=a[i-1]+b[i-1];

        if(result[i]>=10){
            result[i-1]+=result[i]/10;
            result[i]=result[i]%10;

        }
    }

    if(result[0]==0)
    {
        int[]result2=new int[a.length];

     for(int i=0;i<result2.length;i++)
        result2[i]=result[i+1];

        return result2;

    }   
    return result;
}



public  int[] fibonacci(int n)
{
    count++;
    if(n <=counter ){
        return memo[n-1];
    }

    else
    {   
        memo[n-1]= Add(fibonacci(n-1),fibonacci(n-2));
        counter++;
        return memo[counter-1];
    }
}
public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter any number  ");
int b=sc.nextInt();
System.out.println();

FiboTabu r1=new FiboTabu();

long start=System.nanoTime();
r1.initialize(b);
int[] result=r1.fibonacci(b);
long end =System.nanoTime();


System.out.print(b+" th fibonacci number is : ");
for(int i=0;i<result.length;++i)
System.out.print(result[i]);
System.out.println("\nTime taken : "+(end-start)+" ns");
System.out.print("No .of recursion: "+count);
}
}
