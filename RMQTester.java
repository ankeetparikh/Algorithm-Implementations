import java.awt.font.NumericShaper;

/**
 * Created by ankeet on 6/21/16.
 */
public class RMQTester {

    public static void main(String[] args)
    {
        int[] a = {1};
        RangeMinimumQuery rmq =new RangeMinimumQuery(a);
        System.out.println(rmq.RMQ(0,0));
    }
}
