package ru.tolkacheva.sem3.typeofweapon;

public class Shooter {
    String name;
    public Weapon weapon;

    public Shooter(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("name must not be empty");
        this.name = name;
    }

    public void shooting(){
        if (weapon != null) weapon.shoot();
        System.out.println("не могу участвовать в перестрелке");
    }
}
