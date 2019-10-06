import java.util.*;

class FiboLinear{

    Karatsuba r1=new Karatsuba();

    int[][] MatrixMul(int[][] a,int[][] b){

        int[][] c=new int[4][];

            c[0]=r1.Add(r1.Multiplication(a[0], b[0]),r1.Multiplication(a[1], b[2]));
            c[1]=r1.Add(r1.Multiplication(a[0], b[1]),r1.Multiplication(a[1], b[3]));
            c[2]=r1.Add(r1.Multiplication(a[2], b[0]),r1.Multiplication(a[3], b[2]));
            c[3]=r1.Add(r1.Multiplication(a[2], b[1]),r1.Multiplication(a[3], b[3]));
       
        return c;

    }

    int [][] Fibonacci(int n){

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
            tabu[j]=MatrixMul(tabu[j+1], tabu[j+1]);
        }

        int [][] result=new int[4][];

        result[0]=temp;
        result[1]=temp2;
        result[2]=temp2;
        result[3]=temp;

        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)==49){
                result=MatrixMul(result, tabu[i]);
            }
        }
    
            int[][] answer=new int[2][];

            answer[0]=r1.Add(r1.Multiplication(result[0], temp), r1.Multiplication(result[1], temp2));
            answer[1]=r1.Add(r1.Multiplication(result[2], temp), r1.Multiplication(result[3], temp2));
        
            return answer;
        }

    

    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        FiboLinear r2=new FiboLinear();

            System.out.println("Enter any number");
            int n=sc.nextInt();
            int[][] answer =r2.Fibonacci(n);

            
            for(int i=0;i<answer[0].length;i++)
            System.out.print(answer[0][i]);
            
            System.out.println();

            for(int i=0;i<answer[1].length;i++)
            System.out.print(answer[1][i]);

            System.out.println();
        }

}