public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public void mur(){
        System.out.println(name + ": мяу");
    }

    public void murN(int n){
        String res = name + ": ";
        for (int i = 0; i < n; i++){
            if (i == n-1) res += "мяу!";
            else res += "мяу-";
        }
        System.out.println(res);
    }

    public String toString(){
        return "Cat: " + name;
    }
}
