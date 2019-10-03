import java.math.BigInteger;
import java.util.*;

public class FiboTabu{

  static  long count=0;    
    int[][] memo;
    BigInteger counter;
    int[] base;

    
    void initialize(BigInteger n){
        base=new int[1];
        base[0]=1;
       memo=new int[n.intValue()][];
       counter=new BigInteger("2");
       memo[0]=base;
        
        if(n.intValue()>1){
        memo[1]=base;

        
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



public  int[] fibonacci(BigInteger n)
{
    count++;
    if(n.compareTo(counter)==-1 ||n.compareTo(counter)==0 ){
        return memo[n.intValue()-1];
    }

    else
    {
        
        BigInteger temp= n.subtract(BigInteger.ONE);
        BigInteger temp2= temp.subtract(BigInteger.ONE);
        
        memo[n.intValue()-1]= Add(fibonacci(temp),fibonacci(temp2));
        counter=counter.add(BigInteger.ONE);
        BigInteger count=counter.subtract(BigInteger.ONE);
        return memo[count.intValue()];
    }
}
public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter any number  ");
String s=sc.nextLine();

BigInteger b=new BigInteger(s);

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
