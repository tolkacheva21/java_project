public class Way {
    String name;
    int pay;

    public Way(String name, int pay) {
        this.name = name;
        this.pay = pay;
    }

    public String toString(){
        return name + ": " + pay;
    }
}
