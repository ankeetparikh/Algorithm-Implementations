/**
 * Created by ankeet on 7/8/16.
 */
/*
This class contains several different implementations of Binary Search.
Here are the three types covered:
1. Naive Binary Search:
        Here we take in an array A and a target element. The assumption is that
        the array is already sorted. If the element exists in the array, the
        method returns the corresponding index. If the element does not exist,
        then the method returns (-(insertion point)-1). The insertion point is
        the index of the first element greater than the target. (Or A.length if all
        elements are less than the target. Also, if there exist duplicates of the
        target element in the array, then the method returns the index of any 1 of them.

2. First Occurrence Binary Search:
        This method returns the index of the first occurrence of the target
        element in the array. This is especially useful in certain situations.
        If the target does not exist, it returns (-(insertion point)-1_

3. Last Occurrence Binary Search:
        This method returns the index of the last occurrence of target in
        the array. If the target does not exist, it returns
        (-(insertion point)-1)


 */
import java.util.*;
public class BinarySearch {

    public static int NaiveBinarySearch(int[] A, int t)
    {
        int n = A.length;
        int lo = 0, hi=n-1;
        while(lo <= hi)
        {
            int mid = (lo + hi)/2;
            if(A[mid] < t) lo = mid+1;
            else if(A[mid] > t) hi = mid-1;
            else
            {
                //target is found
                return mid;
            }

        }
        return -lo-1;

    }

    public static int FirstOccBinarySearch(int[] A, int t)
    {
        int n = A.length;
        int lo = 0, hi = n-1, ans = -1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(A[mid] < t) lo = mid+1;
            else if(A[mid] > t) hi = mid-1;
            else
            {
                ans = mid;
                hi = mid-1;
            }
        }
        if(ans == -1)
        {
            return -lo-1;
        }
        else return ans;

    }

    public static int LastOccBinarySearch(int[] A, int t)
    {
        int n = A.length;
        int lo = 0, hi = n-1, ans=-1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(A[mid] < t) lo = mid+1;
            else if(A[mid] > t) hi = mid-1;
            else
            {
                ans = mid;
                lo = mid+1;
            }
        }
        if(ans == -1)
        {
            return -lo-1;
        }
        else return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {0,75,75,100};
        Arrays.sort(A);
        System.out.println(LastOccBinarySearch(A,  4));
    }

}
