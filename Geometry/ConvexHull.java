package Geometry;

/**
 * Created by ankeet on 1/14/17.
 */
import java.util.*;
import java.io.*;
public class ConvexHull {

    public static double distsq(Point a, Point b){
        return 1L*(a.x-b.x)*(a.x-b.x) + 1L*(a.y-b.y)*(a.y-b.y);
    }

    public static int orientation(Point a, Point b, Point c){
        //look at a -> b -> c
        // 0 for collinear
        // 1 for left turn
        // 2 for right turn

        double cross = (c.x-a.x)*(b.y-a.y) - (b.x-a.x)*(c.y-a.y);
        if(cross < 0) return 1;
        if(cross == 0) return 0;
        return 2;

    }

    public static Point[] ConvexHull(Point[] points){
        int n = points.length;
        if(n<3) return null;
        Point p0 = points[0];
        for(int i=1; i<n; i++){
            if(points[i].y < p0.y) p0 = points[i];
            if(points[i].y == p0.y && points[i].x < p0.x) p0 = points[i];
        }
        final Point p0c = p0;
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int o = orientation(p0c,a,b);
                if(o != 0){
                    if(o==1) return -1;
                    return 1;
                }
                else{
                    double d = distsq(p0c,a) - distsq(p0c,b);
                    if(d<0) return -1;
                    if(d>0) return 1;
                    return 0;
                }
            }
        });

        Point[] cvx = new Point[n];
        cvx[0] = points[0];
        cvx[1] = points[1];
        cvx[2] = points[2];
        int m = 3; //last unused index
        for(int i=3; i<n; i++){
            while(m>=2 && orientation(cvx[m-2], cvx[m-1], points[i]) != 1) m--;

            cvx[m++] = points[i];
        }


        Point[] res = new Point[m];
        for(int i=0; i<m; i++) res[i] = cvx[i];
        return res;



    }

    public static void main(String[] args){
        Point[] p = new Point[6];




        p[0] = new Point(0,0);
        p[1] = new Point(-1,-1);
        p[2] = new Point(1,1);
        p[3] = new Point(2,2);
        p[4] = new Point(3,3);
        p[5] = new Point(4,4);
        System.out.println(Arrays.toString(ConvexHull(p)));
    }

}
