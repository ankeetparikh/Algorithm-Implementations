package Strings;

/**
 * Created by ankeet on 10/21/16.
 */
public class NaiveStringMatching {

    public static int firstocc(String txt, String pat)
    {
        int n = txt.length();
        int m = pat.length();
        if(m > n) return -1;
        for(int i=0; i<=n-m; i++)
        {
            boolean found = true;
            for(int j=0; j<m; j++)
            {
                if(txt.charAt(i+j) != pat.charAt(j))
                {
                    found = false;
                    break;
                }
            }
            if(found) return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        System.out.println(firstocc(txt, pat));
    }
}
