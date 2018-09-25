package lab02.formation;

public class CustomFormation {

    private int positions[] = new int[]{1, 4, 4, 2};

    private final static String[] LINES = new String[]{
            "---------",
            "----O----",
            "--O---O--",
            "-O--O--O-",
            "O--O-O--O",
            "O-O-O-O-O",
            "OO-O-O-OO",
            "OOO-O-OOO",
            "OOOO-OOOO"
    };

    public CustomFormation(int gkCount, int dfCount, int mfCount, int fwCount) {
        if ( gkCount < 1 || dfCount < 1 || mfCount < 1 || fwCount < 1 ){{
            System.err.println("Na svakoj poziciji mora biti barem 1 igrac!");
            return;
        }}

        if ( gkCount != 1 ){
            System.err.println("Broj golmana mora biti 1!");
            return;
        }

        if ( gkCount + dfCount + mfCount + fwCount != 11 ){
            System.err.println("Ukupan broj igraca mora biti 11!");
        }
        positions[0] = gkCount;
        positions[1] = dfCount;
        positions[2] = mfCount;
        positions[3] = fwCount;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for ( int position : positions ){
            builder.append(LINES[position]);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static void main(String[] args) throws InterruptedException {

        new CustomFormation(0, 5, 5, 1);
        new CustomFormation(2, 3, 5, 1);
        new CustomFormation(1, 5, 5, 1);

        System.out.println(new CustomFormation(1, 4, 5, 1).toString());
    }

}
