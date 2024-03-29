import java.util.*;

public class FiboSpace{

    int[] a,b,c;

    void initialize(){
     a=new int[1];
     b=new int[1];

    a[0]=1;
    b[0]=1;
    }


    int[] equal(int[]a,int[]b){

    int diff=a.length-b.length;
    int[] b2=new int[a.length];

    for(int i=diff;i<a.length;i++)
    b2[i]=b[i-diff];
     
    return b2;
 }

 

int[] add(int[] a, int[]b)
{
    b=equal(a, b);        

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
    if(n<=2)
    return a;

    else{
        for(int i=3;i<=n;i++){
            c=add(b, a);
            a=b;
            b=c;
        }
        return c;
    }
}
public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter any number  ");
int b=sc.nextInt();
System.out.println();

FiboSpace r1=new FiboSpace();

long start=System.nanoTime();
r1.initialize();
int[] result=r1.fibonacci(b);
long end =System.nanoTime();


System.out.print(b+" th fibonacci number is : ");
for(int i=0;i<result.length;++i)
System.out.print(result[i]);
System.out.println("\nTime taken : "+(end-start)+" ns");

}
}
