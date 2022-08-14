package homework8;

public enum Species {
    DOG(false,4,true),
    DOMESTIC_CAT(false,4,true),
    ROBO_CAT(false,4,false),
    BIRD(false,0,false),
    FISH(true,2,true),
    UNKNOWN(false,0,false);

    public final boolean canFly;
    public final int numberOfLegs;
    public final boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
}
