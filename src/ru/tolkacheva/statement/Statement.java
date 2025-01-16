package ru.tolkacheva.statement;

import java.util.List;

public class Statement {
    private String name;
    private String text;
    private List<String> signatures;
    private boolean isAccepted;
    private final int n;
    private int tempN;

    public Statement(String name, String text, List<String> signatures, int n) {
        this.name = name;
        this.text = text;
        this.signatures = signatures;
        this.n = n;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        if (tempN < n){
            isAccepted = accepted;
            tempN++;
        }
    }
}
