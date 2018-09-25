package lab03.prob2.tester;

import lab03.prob2.HashTable;
import lab03.prob2.SimpleHashTable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ispitivac implements Provjera {

    private static final String KRAJ = "kraj";
    private static final Pattern pattern = Pattern.compile("\\[([0-9]+), ([0-9]{1,2})\\]");

    private HashTable<String, Integer> pali = new SimpleHashTable<>();
    private HashTable<String, Integer> prosli = new SimpleHashTable<>();

    private Set<String> ocjenjen = new HashSet<>();
    private Set<String> bioNaUvidima = new HashSet<>();

    public void ispitaj(){

        Scanner sysIn = new Scanner(System.in);
        String line;

        for ( int i = 0; i < 2; i++ ){
            while ( !(line = sysIn.nextLine()).equals(KRAJ) ){
                Matcher matcher = pattern.matcher(line);
                if ( !matcher.find() ){
                    continue;
                }
                if ( i == 0 ) {
                    provjeriProlaz(matcher.group(1), Integer.parseInt(matcher.group(2)));
                } else {
                    uvidi(matcher.group(1), Integer.parseInt(matcher.group(2)));
                }
            }
            System.out.println("PALI: \n" + pali.toString() + "PROSLI: \n" + prosli.toString()) ;
        }
        sysIn.close();
    }

    @Override
    public final void provjeriProlaz(String jmbag, int bodovi) {
        if ( !ocjenjen.add(jmbag) ) {
            return;
        }

        dodaj(jmbag, bodovi);

    }

    @Override
    public final void uvidi(String jmbag, int dodatniBodovi) {

        if ( !ocjenjen.contains(jmbag) ){
            return;
        }

        if ( !bioNaUvidima.add(jmbag) ) {
            return;
        }

        int trenutniBodovi;
        if ( pali.containsKey(jmbag) ){
            trenutniBodovi = pali.get(jmbag);
            pali.remove(jmbag);
        } else {
            trenutniBodovi = prosli.get(jmbag);
            prosli.remove(jmbag);
        }

        dodaj(jmbag, trenutniBodovi + dodatniBodovi);
    }

    private void dodaj(String jmbag, int bodovi) {
        if ( bodovi >= 50 ){
            prosli.put(jmbag, bodovi);
        } else {
            pali.put(jmbag, bodovi);
        }
    }

    public static void main(String[] args) {
        new Ispitivac().ispitaj();
    }

}
