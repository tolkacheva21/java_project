final class Fraction {
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
}
