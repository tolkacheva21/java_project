public class House {
    private final int n;

    public House(int n) {
        if (n <= 0) throw new IllegalArgumentException("flats must be positive");
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public String toString(){
        if (n == 1) return "House with " + n + " flat";
        return "House with " + n + " flats";
    }
}
