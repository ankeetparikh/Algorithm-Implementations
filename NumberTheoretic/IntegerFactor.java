package NumberTheoretic;

/**
 * Created by ankeet on 7/25/16.
 */
public class IntegerFactor {


    public static void factor(long n)
    {

        while(n%2 == 0)
        {
            System.out.print("2 ");
            n/=2;
        }
        for(long i = 3; i*i<n; i+=2)
        {
            while(n%i == 0)
            {
                System.out.print(i + " ");
                n/=i;
            }
        }
        if(n>2)
        {
            System.out.println(n);
        }

    }

    public static void main(String[] args)
    {
        factor(100000000000L);
    }

}
