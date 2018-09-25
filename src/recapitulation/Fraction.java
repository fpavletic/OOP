package recapitulation;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator; // not sure what to do if denominator is 0
    }

    private Fraction(Fraction other) {
        numerator = other.numerator;
        denominator = other.denominator;
    }

    public void add ( Fraction other ){

    }

    public void subtract ( Fraction other ){

    }

    public void multiply ( Fraction other ){

    }

    public void divide ( Fraction other ){
        Fraction tmp = new Fraction(other);
        tmp.invert();
        multiply(tmp);
    }

    public void invert () {
        numerator ^= denominator;
        denominator ^= numerator;
        numerator ^= denominator;
    }

}
