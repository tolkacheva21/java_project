public class Gun {
    private int patrons = 3;
    private final int max;

    public Gun(int patrons, int max) {
        if (patrons < 0 || max < 0) throw new IllegalArgumentException("patrons must be positive");
        this.patrons = patrons;
        this.max = max;
    }

    public void setPatrons(int patrons) {
        if (patrons < 0) throw new IllegalArgumentException("patrons must be positive");
        if (patrons > max){
            System.out.println((patrons - max) + " extra patrons");
            this.patrons = max;
        }
        this.patrons = patrons;
    }

    public int getPatrons() {
        return patrons;
    }

    public int getMax() {
        return max;
    }

    public int returnPatrons(){
        int temp = patrons;
        this.patrons = 0;
        return temp;
    }

    public boolean isEmpty(){
        return patrons == 0;
    }

    public void shoot(){
        if (patrons > 0){
            System.out.println("Bah");
            patrons -= 1;
        }
        else{
            System.out.println("Clac");
        }
    }
}
