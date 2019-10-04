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


    int[] Substract(int[] a, int[]b){
        
        if(a.length>b.length){
        b=Equal(a,b);
        }

        int sub=0;
        int carry =0;

        int[] result=new int[a.length];

        for(int i=a.length-1;i>=0;i--){

            sub=a[i]-b[i]-carry;
            carry=0;

            if(sub<0){
                carry=1;
                sub+=10;
            }
            result[i]=sub;

        }
        int temp=0;
        while(temp<result.length && result[temp]==0  ){
            temp++;
        }
            
        if(temp!=0){
            int[] result2=new int[result.length-temp];

            for(int i=0;i<result2.length;i++)
            result2[i]=result[i+temp];
            
            return result2;
        }
    
        return result;
    }        

    


public  int[] fibonacci(int[] n)
{
    if(n.length==1 && (n[0]==1 || n[0]==2))
    {
        int [] result= new int[1];
        result[0]=1;
        return result;
    }

    else
    {
        int [] temp= new int[1];
        temp[0]=1;
        int [] temp2= Substract(n,temp);
        
        return Add(fibonacci(temp2),fibonacci(Substract(temp2,temp)));
    }
}

public static void main(String[]args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter number of elements of fibonacci series to be printed: ");
String s=sc.nextLine();

int[] n=new int[s.length()];

for(int i=0; i<s.length();i++)
n[i]=Character.getNumericValue(s.charAt(i));


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
