package lab02;

public enum Formation {
    F442(4, 4, 2),
    F352(3, 5, 2),
    F541(5, 4, 1);

    private int DFCount;
    private int MFCount;
    private int FWCount;

    Formation(int DFCount, int MFCount, int FWCount) {
        this.DFCount = DFCount;
        this.MFCount = MFCount;
        this.FWCount = FWCount;
    }

    public int getCount(PlayingPosition position) {
        switch (position){
            case GK:
                return 1;
            case DF:
                return DFCount;
            case MF:
                return MFCount;
            case FW:
                return FWCount;
            default:
                return -1;
        }
    }
}
