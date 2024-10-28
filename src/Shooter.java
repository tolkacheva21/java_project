public class Shooter {
    String name;
    Weapon weapon;

    public Shooter(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("name must not be empty");
        this.name = name;
    }

    public void shooting(){
        if (weapon != null) weapon.shoot();
        System.out.println("не могу участвовать в перестрелке");
    }
}
