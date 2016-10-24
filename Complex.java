/**
 * Created by ankeet on 6/10/16.
 */
public class Complex{
    public double real = 0;
    public double imag = 0;
    public Complex(double a, double b)
    {
        this.real = a;
        this.imag = b;
    }

    public Complex add(Complex b)
    {
        return new Complex(this.real+b.real, this.imag+b.imag);
    }

    public Complex sub(Complex b)
    {
        return new Complex(this.real-b.real, this.imag-b.imag);
    }

    public Complex mult(Complex b)
    {
        double re = this.real*b.real - this.imag*b.imag;
        double im = this.real*b.imag + this.imag*b.real;
        return new Complex(re, im);
    }

    public Complex mult(double b)
    {
        return new Complex(this.real*b, this.imag*b);
    }

    public Complex div(Complex b)
    {

        double denom = b.real*b.real + b.imag*b.imag;
        double re = this.real*b.real + this.imag*b.imag;
        double im = this.imag*b.real-this.real*b.imag;

        re/=denom;
        im/=denom;

        return new Complex(re, im);
    }

    public Complex conjugate()
    {
        return new Complex(this.real, -this.imag);
    }


    public String toString()
    {
        return this.real + " + " + this.imag + "i";
    }


}