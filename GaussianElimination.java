/**
 * Created by ankeet on 2/5/17.
 */
public class GaussianElimination {

    // returns x that satisfies
    // Ax = b
    // if no such x, return null

    public static double[] solve(double[][] A, double[] b){
        double eps = 1e-10;
        int N = b.length;

        for(int k = 0; k < N; k++){

            int maxind = k;
            for(int i = k+1; i < N; i++){
                if(Math.abs(A[i][k]) > Math.abs(A[maxind][k]) ){
                    maxind = i;
                }
            }

            if(Math.abs(A[maxind][k]) < eps){
                System.out.println("Matrix is singular, or nearly singular.");
                return null;
            }

            double[] tmp = A[k];
            A[k] = A[maxind];
            A[maxind] = tmp;

            double t = b[k];
            b[k] = b[maxind];
            b[maxind] = t;

            for(int i = k+1; i<N; i++){
                double f = A[i][k] / A[k][k];
                b[i] -= f*b[k];
                for(int j=k+1; j<N; j++){
                    A[i][j] -= A[k][j]*f;
                }
                A[i][k] = 0;
            }


        }

        double[] x = new double[N];
        for(int i = N - 1; i>=0; i--){
            double sum = 0;
            for(int j = i + 1; j<N; j++){
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    public static void main(String[] args){
        int N = 3;
        double[][] A = { { 0, 1,  1 },
                { 2, 4, -2 },
                { 0, 3, 15 }
        };
        double[] b = { 4, 2, 36 };
        double[] x = solve(A, b);


        // print results
        for (int i = 0; i < N; i++) {
            System.out.println(x[i]);
        }
    }
}
