public class Cuckoo extends Bird{
    public Cuckoo() {}

    @Override
    public void sing() {
        int n = (int)(Math.random() * 10) + 1;
        for (int i = 0; i < n; i++){
            System.out.println("ку-ку");
        }
    }
}
