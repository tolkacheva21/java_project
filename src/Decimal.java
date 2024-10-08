public class Decimal {
    int chisl;
    int znam;

    public Decimal(int chisl, int znam) {
        this.chisl = chisl;
        this.znam = znam;
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
