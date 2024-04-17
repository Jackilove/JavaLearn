import java.util.Scanner;
import java.math.BigInteger;
public class doFactorial {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        BigInteger result= Factorial(n);
        System.out.println(result);
    }

    public static BigInteger Factorial(int num){
        BigInteger result = BigInteger.ONE;
        for(int i=1;i<=num;i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
