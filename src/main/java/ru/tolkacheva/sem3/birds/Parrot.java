package ru.tolkacheva.sem3.birds;

public class Parrot implements Bird{
    private String text;

    public Parrot(String text) {
        setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void sing() {
        int n = (int)(Math.random() * text.length()) + 1;
        for (int i = 0; i < n; i++){
            System.out.print(text.charAt(i));
        }
    }
}
