package ru.tolkacheva.sem3.typeofweapon;

public class Gun extends Weapon{
    private final int max;

    public Gun(int max) {
        super(3);
        if (max < 0) throw new IllegalArgumentException("patrons must be positive");
        this.max = max;
    }

    @Override
    public int load(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("patrons must be positive");
        if (ammo > max){
            System.out.println((ammo - max) + " extra patrons");
            super.load(max);
        }
        super.load(ammo);
        return super.ammo();
    }

    public int getMax() {
        return max;
    }

    public int returnAmmo(){
        int temp = super.ammo();
        super.ammo = 0;
        return temp;
    }

    public boolean isEmpty(){
        return super.ammo() == 0;
    }

    @Override
    public void shoot(){
        if (super.ammo() > 0){
            System.out.println("Bah");
            super.load(super.ammo() - 1);
        }
        else{
            System.out.println("Clac");
        }
    }
}
