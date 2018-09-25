package lab04.task02;

import java.util.Currency;

public class Artikl {

    String name;
    Currency price;

    public Artikl(String name, Currency price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Currency getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o){
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Artikl artikl = (Artikl) o;

        return name != null ? name.equals(artikl.name) : artikl.name == null;
    }

    @Override
    public int hashCode(){
        return name != null ? name.hashCode() : 0;
    }

}
