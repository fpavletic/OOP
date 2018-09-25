package lab03.prob2.predicate;


import lab03.prob2.predicate.Ispitivac;

public class BaremN implements Ispitivac<Integer> {

    private int n;

    public BaremN(int n) {
        this.n = n;
    }

    @Override
    public boolean prolazi(Integer data) {
        return n <= data;
    }
}
