package homework6;

public enum Species {
    CAT(false,4,true),
    DOG(false,4,true),
    HAMSTER(false,4,true),
    BIRD(false,0,false),
    FISH(true,2,true);

    public final boolean canFly;
    public final int numberOfLegs;
    public final boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
}
