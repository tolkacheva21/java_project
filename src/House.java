public class House {
    final int n;

    public House(int n) {
        this.n = n;
    }

    public String toString(){
        if (n == 1) return "House with " + n + " flat";
        return "House with " + n + " flats";
    }
}
