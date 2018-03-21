import java.util.Arrays;

/**
 * Created by ankeet on 11/28/16.
 */
public class NextPermutation {

    public static int nextperm(int[] a){
        int n = a.length;
        int k = n - 2;
        while(k>=0 && !(a[k] < a[k+1])) k--;
        if(k < 0){
            return -1;
        }
        int l = n - 1;
        while(!(a[k] < a[l])) l--;
        int temp = a[k];
        a[k] = a[l];
        a[l] = temp;
        int i = k+1;
        int j = n-1;
        while(i<=j){
            temp= a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return 0;
    }

    public static void main(String[] args){
        int[] a = {3,2,1};
        nextperm(a);
        System.out.println(Arrays.toString(a));
    }
}
