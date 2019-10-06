import java.util.Scanner;

class MultiplicationS{
    
       int[] multiplication(int[]a,int[] b){
    
            
                                                    //no. of digits in resulting number would 
                                                    //always be less than sum of digits 
      int[] result =new int[a.length+b.length];   // of two number
    
      int counter=0;      //counter suggests where to store current product
      int carry =0;
      int product=0;
            
    
            for(int i=b.length-1;i>=0;i--){
                
                carry=0;
                counter=result.length-1;

                for(int k=b.length-1-i;k>0;k--){
                    result[counter]+=0;             //This loop sets initial zeros in multiplication
                    counter--;
                }

   
                for(int j=a.length-1;j>=0;j--){
                   
                    product=(b[i]*a[j])+carry;
   
    
                if(product>=10)
                {
                carry=product/10;
                product=product%10;
                      
                    if(j==0){
                    result[counter]+=product;
                        
                    if(result[counter]>=10){
                    result[counter-1]+=result[counter]/10;
                    result[counter]=result[counter]%10;
                    }
                    
                    counter--;
                    product=carry;
                        
                    }
                }
    
                        else{
                            carry=0;
                            }
                    
                result[counter]+=product;
                          
                if(result[counter]>=10){
                result[counter-1]+=result[counter]/10;
                result[counter]=result[counter]%10;
                }  
                        
                          
                          counter--;              
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
    
    
    
        public static void main(String[]args)throws Exception
        {
    
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter first number");
            String A= sc.nextLine();

            System.out.println("\nEnter Second number:");
            String B=sc.nextLine();

            int [] a=new int[A.length()];
            int [] b=new int[B.length()];
    
            
    
                for(int j=0;j<A.length();j++)
                {
                    a[j]=Character.getNumericValue(A.charAt(j));
                }
            
                for(int j=0;j<B.length();j++)
                {
                    b[j]=Character.getNumericValue(B.charAt(j));
                }
    
                MultiplicationS r1=new MultiplicationS();
               int [] r= r1.multiplication(a, b);

               System.out.println();

               for(int i=0;i<r.length;i++)
               System.out.print(r[i]);
    }
    }
    