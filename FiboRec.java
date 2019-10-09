import java.util.*;

class FiboRec{


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
    if(n==1 || n==2)
    {
        int [] result= new int[1];
        result[0]=1;
        return result;
    }

    else
    {        
        return Add(fibonacci(n-1),fibonacci(n-2));
    }
}

public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter number of elements of fibonacci series to be printed: ");
int n=sc.nextInt();

System.out.println();

FiboRec r1=new FiboRec();

long start=System.nanoTime();
int [] result=r1.fibonacci(n);
long end =System.nanoTime();



for(int i=0;i<result.length;i++)
System.out.print(result[i]);

System.out.println("\nTime taken : "+(end-start)+" ns");
}
}
