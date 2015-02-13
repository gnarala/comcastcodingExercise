import java.text.DecimalFormat;
import java.util.*;

public class OptimalSquareCalc{

    public static void main(String []args){       

       int size=5;
       float[] num = new float[size]; 
       float result=0;
       float fudge = 0; 
       print_welcome();
       Scanner readInput = new Scanner(System.in);  //instantiate the scanner object,readInput is a reference.

		// try/catch input mismatch exception
		try {
		    for (int i=0; i<size; i++) {
		      System.out.println("Enter square size");  
			  num[i] = readInput.nextFloat();//use the reference and send message by calling a method nextFloat()
            }
            System.out.println("Enter result");
			result = readInput.nextFloat();
		}
		catch(InputMismatchException e) {
			//catches the exception and prints the output message.
			System.out.println("ERROR MESSAGE:You entered string  instead of numbers");
			System.out.println("You must enter floats. Please try again.\n" );
		}
		
		calculate(num, result, fudge, size);
		
    }
    public static void calculate(float[] num, float result, float fudge, int size) { 
      int mybit;
      float sum=0;
      float[] opt_sol = new float [size];
      for (int i=1; i< Math.pow(2,size); i++) {
        for(int j=0; j< size; j++) {
            mybit = (i & ( 1 << j));
            //System.out.println(mybit);
            if (mybit ==0) { 
                opt_sol[j] = 0;
            } else { 
                sum = sum + num[j];
                opt_sol[j] = num[j];
                //System.out.println(opt_sol[j]);
            }
        }
        //System.out.println(" Sum = " + sum + " Result = " + result);
        if (result ==sum) {
            print_solution(opt_sol, result, size);
        }        
        sum=0;
      }
    }   
    public static void print_solution(float [] num, float result, int size) {
      System.out.print("Optimal solution [" );
      DecimalFormat df = new DecimalFormat("#.##");
      for (int i=0; i<size; i++) {
        if (num[i]!=0) { System.out.print(df.format(num[i]) + ", "); }
        else { System.out.print("X, "); }
      }
      System.out.println("] = " + result );
    } 
    public static void print_welcome(){ 
	  System.out.println("Optimal square calculator");
	  System.out.println("Provide Square size inputs - default it takes 5 sizes but this can be changed via variable");
	  System.out.println("[ 206, 140, 300, 52, 107] = 613");
    }
    
}
