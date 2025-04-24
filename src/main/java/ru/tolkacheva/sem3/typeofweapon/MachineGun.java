package ru.tolkacheva.sem3.typeofweapon;

public class MachineGun extends Gun{
    private final int fireRate;

    public MachineGun(int max, int fireRate) {
        super(max);
        if (fireRate <= 0) throw new IllegalArgumentException("Fire rate must be positive");
        this.fireRate = fireRate;
    }

    public MachineGun() {
        this(30, 30);
    }

    public MachineGun(int max){
        this(max, max / 2);
    }

    public int getFireRate() {
        return fireRate;
    }

    public void shoot(){
        if (super.ammo() >= this.fireRate){
            for (int i = 0; i < fireRate; i++){
                super.shoot();
            }
        }
    }

    public void timeShoot(int n){
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        for (int i = 0; i < n; i++) this.shoot();
    }
}
