package Geometry;

/**
 * Created by ankeet on 8/4/16.
 */
public class Point {

    double x, y;

    public Point(double xc, double yc)
    {
        x=xc;
        y=yc;
    }

    public void rotate(double ang)
    {
        double c = Math.cos(ang);
        double s = Math.sin(ang);
        double xc = x*c-y*s;
        double yc = x*s+y*c;
        x=xc;
        y=yc;
    }

    public String toString(){
        return "( " + x + " , " + y + " )";
    }

}
