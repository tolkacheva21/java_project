package ru.tolkacheva.sem3.fractions;

import java.util.Objects;

final public class Fraction extends Number implements Cloneable{
    private final int chisl;
    private final int znam;

    public Fraction(int chisl, int znam) {
        if (znam <= 0) throw new IllegalArgumentException("znam must be positive");
        this.chisl = chisl;
        this.znam = znam;
    }

    public int getChisl() {
        return chisl;
    }

    public int getZnam() {
        return znam;
    }

    public String sum(int chisl2, int znam2){
        return (chisl * znam2 + chisl2 * znam) + "/" + (znam * znam2);
    }

    public String razn(int chisl2, int znam2){
        return (chisl * znam2 - chisl2 * znam) + "/" + (znam * znam2);
    }

    public String mnoj(int chisl2, int znam2){
        return (chisl * chisl2) + "/" + (znam * znam2);
    }

    public String del(int chisl2, int znam2){
        return (chisl * znam2) + "/" + (znam * chisl2);
    }

    public String toString(){
        return chisl + "/" + znam;
    }

    @Override
    public int intValue() {
        return chisl/znam;
    }

    @Override
    public long longValue() {
        return chisl/znam;
    }

    @Override
    public float floatValue() {
        return chisl/znam;
    }

    @Override
    public double doubleValue() {
        return chisl/znam;
    }

    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return chisl == fraction.chisl && znam == fraction.znam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chisl, znam);
    }
}
