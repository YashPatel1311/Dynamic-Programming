import java.util.*;

public class FiboTabu{
  
    int[][] tabu;
    int counter;
    int[] base;
    int flag=0;
    
    void initialize(int n){
        base=new int[1];
        base[0]=1;
       tabu=new int[n][];
       counter=1;
       tabu[0]=base;
        
        if(n>1){
        tabu[1]=base;         
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
 
    if(n<=2)
    return tabu[0];

    else{
            for(int i=2;i<n;i++)
            tabu[i]=Add(tabu[i-1], tabu[i-2]);
    
            return tabu[n-1];
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
}
}
