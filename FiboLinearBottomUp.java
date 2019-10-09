import java.util.*;

class FiboLinearBottomUp{

    public int[] equal(int[]a,int[]b){

        int diff=a.length-b.length;
 
        int[] b2=new int[a.length];
 
        for(int i=diff;i<a.length;i++)
        b2[i]=b[i-diff];
 
         
        return b2;
     }
     

    int[] add(int[] a, int[]b)
    {

        if(a.length>b.length)
        b=equal(a,b);

       if(a.length<b.length)
        a=equal(b,a);

    int[] result=new int[a.length+1];

        for(int i=result.length-1;i>=1;i--){
            result[i]+=a[i-1]+b[i-1];

            if(result[i]>=10){
                result[i-1]+=result[i]/10;
                result[i]=result[i]%10;

            }
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


    MultiplicationS r3=new MultiplicationS();

    int[][] matrixMul(int[][] a,int[][] b){

        int[][] c=new int[4][];

            c[0]=add(r3.multiplication(a[0], b[0]),r3.multiplication(a[1], b[2]));
            c[1]=add(r3.multiplication(a[0], b[1]),r3.multiplication(a[1], b[3]));
            c[2]=add(r3.multiplication(a[2], b[0]),r3.multiplication(a[3], b[2]));
            c[3]=add(r3.multiplication(a[2], b[1]),r3.multiplication(a[3], b[3]));
       
        return c;

    }

    int [][] fibonacci(int n){

        String binary=Integer.toBinaryString(n-1);
        
        int[] temp=new int[1];
        temp[0]=1;
        int[] temp2=new int[1];
        temp2[0]=0;

        int[][][]  tabu=new int[binary.length()][4][];

        tabu[binary.length()-1][0]=temp;
        tabu[binary.length()-1][1]=temp;
        tabu[binary.length()-1][2]=temp;
        tabu[binary.length()-1][3]=temp2;

        for(int j=binary.length()-2;j>=0;j--){
            tabu[j]=matrixMul(tabu[j+1], tabu[j+1]);
        }

        int [][] result=new int[4][];

        result[0]=temp;
        result[1]=temp2;
        result[2]=temp2;
        result[3]=temp;

        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)==49){
                result=matrixMul(result, tabu[i]);
            }
        }
    
            int[][] answer=new int[2][];

            answer[0]=add(r3.multiplication(result[0], temp), r3.multiplication(result[1], temp2));
            answer[1]=add(r3.multiplication(result[2], temp), r3.multiplication(result[3], temp2));
        
            return answer;
        }

    

    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        FiboLinearBottomUp r2=new FiboLinearBottomUp();

            System.out.println("Enter any number");
            int n=sc.nextInt();
            int[][] answer =r2.fibonacci(n);

            
            for(int i=0;i<answer[0].length;i++)
            System.out.print(answer[0][i]);
            
            System.out.println();

            for(int i=0;i<answer[1].length;i++)
            System.out.print(answer[1][i]);

            System.out.println();
        }

}