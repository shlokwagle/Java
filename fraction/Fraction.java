public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;

    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public int getNum() {
        return numerator;
    }

    public void setNum(int numerator) {
        this.numerator = numerator;
    }

    public int getDen() {
        return denominator;
    }

    public void setDen(int denominator) {
        if (denominator != 0)
            this.denominator = denominator;
        else
            this.denominator = 1;
    }

    public void add(Fraction f) {
        int n1 = getNum();
        int d1 = getDen();
        int n2 = f.getNum();
        int d2 = f.getDen();
        int n = (n1 * d2) + (n2 * d1);
        int d = (d1 * d2);
        setNum(n);
        setDen(d);

    }

    public void subtract(Fraction f) {
        int n1 = getNum();
        int d1 = getDen();
        int n2 = f.getNum();
        int d2 = f.getDen();
        int n = (n1 * d2) - (n2 * d1);
        int d = (d1 * d2);
        setNum(n);
        setDen(d);
    }

    public void multiply(Fraction f) {
        int n1 = getNum();
        int d1 = getDen();
        int n2 = f.getNum();
        int d2 = f.getDen();
        int n = (n1 * n2);
        int d = (d1 * d2);
        setNum(n);
        setDen(d);
    }

    public void divide(Fraction f) {
        int n1 = getNum();
        int d1 = getDen();
        int n2 = f.getNum();
        int d2 = f.getDen();
        int n = (n1 * d2);
        int d = (d1 * n2);
        setNum(n);
        setDen(d);
    }

    public void reduce() {
        int n = getNum();
        int d = getDen();
        int hcf = 1;
        for (int i = 1; i <= n || i <= d; i++) {
            if (n % i == 0 && d % i == 0)
                hcf = i;
        }
        n = n / hcf;
        d = d / hcf;
        setNum(n);
        setDen(d);

    }

    public boolean isEqual(Fraction f) {
        reduce();
        f.reduce();
        int n1 = getNum();
        int d1 = getDen();
        int n2 = f.getNum();
        int d2 = f.getDen();
        if (n1 == n2 && d1 == d2)
            return true;
        else
            return false;
    }

    public String toString() {
        String s;
        s = getNum() + "/" + getDen();
        return s;
    }

}
