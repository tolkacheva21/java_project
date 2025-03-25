package ru.tolkacheva.fractions;

public class FractionGenerator {
    private static final FractionGenerator GENERATOR = new FractionGenerator();

    public static FractionGenerator createGenerator(){
        return GENERATOR;
    }

    public Fraction createFraction(int chisl, int znam){
        return new Fraction(chisl, znam);
    }
}
