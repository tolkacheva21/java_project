package ru.tolkacheva.animals;

public class Cat implements Meowable{
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow(){
        System.out.println(name + ": мяу");
    }

    public void meowN(int n){
        String res = name + ": ";
        for (int i = 0; i < n; i++){
            if (i == n-1) res += "мяу!";
            else res += "мяу-";
        }
        System.out.println(res);
    }

    public String toString(){
        return "ru.tolkacheva.animals.Cat: " + name;
    }
}
