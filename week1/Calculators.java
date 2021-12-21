import java.util.Scanner;

class operations {
    int Add( int x, int y) {
        return (x+y);
    }
    int Sub( int x, int y) {
        return (x-y);
    }
    int MUL( int x, int y) {
        return (x*y);
    }
    int Div( int x, int y) {
        return (x/y);
    }
    int Rem(int x, int y) {
        return x%y;
    }
}

public class Calculators {
    public int Calculate(int i, int x, int y) {
        operations op = new operations();
        switch(i) {
            case 1: return op.Add(x, y);
            case 2: return op.Sub(x, y);
            case 3: return op.MUL(x, y);
            case 4: return op.Div(x, y);
            case 5: return op.Rem(x, y);
        default: return 0;
        }
    }
    
    static int toInteger(String s) {
         return Integer.parseInt(s);
     }
    public static void main(String[] args) {

        System.out.println(
            "Please choose operation you want: \n" +
            "1: Addition \n" +
            "2: Substraction \n" +
            "3: Multiplication \n" +
            "4: Division \n"+
            "5: Remainder \n");
            
        Scanner input = new Scanner(System.in);
        //get i;
        int i = toInteger(input.next());
        // System.out.println(i);
        // get x;
        System.out.println("Please input the first input:");
        int x = toInteger(input.next());
        // System.out.println(x);
        //get y;
        System.out.println("Please input the second input:");
        int y = toInteger(input.next());
        // System.out.println(y);
        input.close();

        Calculators cal = new Calculators();
        int Result = cal.Calculate(i, x, y);
        System.out.println("The result is: " + Result);
        
        }
}
