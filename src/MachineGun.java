public class MachineGun extends Gun{
    private final int fireRate;

    public MachineGun(int patrons, int max, int fireRate) {
        super(patrons, max);
        if (fireRate <= 0) throw new IllegalArgumentException("Fire rate must be positive");
        this.fireRate = fireRate;
    }

    public MachineGun() {
        this(30, 30, 30);
    }

    public MachineGun(int max){
        this(max, max, max / 2);
    }

    public int getFireRate() {
        return fireRate;
    }

    public void shoot(){
        if (super.getPatrons() >= this.fireRate){
            for (int i = 0; i < fireRate; i++){
                System.out.println("Bah");
                super.setPatrons(super.getPatrons() - 1);
            }
        }
        else{
            System.out.println("Clac");
        }
    }

    public void timeShoot(int n){
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        for (int i = 0; i < n; i++) this.shoot();
    }
}
