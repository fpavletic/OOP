package lab03.prob2.consumer;

import lab03.prob2.consumer.Obrada;

public class ProsjecnaVrijednost implements Obrada<String, Integer> {

    private int count;
    private double sum;

    @Override
    public void obradi(String key, Integer value) {
        count++;
        sum+=value;
    }

    public double prosjek(){
        return sum / count;
    }
}
