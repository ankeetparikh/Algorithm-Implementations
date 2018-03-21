package NumberTheoretic;

/**
 * Created by ankeet on 7/25/16.
 */
public class IntegerFactor {


    public static void factor(long n)
    {


        for(long i = 2; i*i<=n; i=i==2?3:i+2)
        {
            while(n%i == 0)
            {
                System.out.print(i + " ");
                n/=i;
            }
        }
        if(n>=2)
        {
            System.out.println(n);
        }

    }

    public static void main(String[] args)
    {
        factor(4L);
    }

}
