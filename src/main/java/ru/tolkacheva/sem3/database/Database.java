package ru.tolkacheva.sem3.database;

import java.util.List;

public class Database {
    private List<String> dataList;
    private int curConnection;
    private int maxConnection;

    public Database(int maxConnection) {
        dataList = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        this.maxConnection = maxConnection;
    }

    public List<String> getData() {
        return dataList;
    }

    public void addCurConnection() {
        curConnection += 1;
    }

    public int getCurConnection() {
        return curConnection;
    }

    public int getMaxConnection() {
        return maxConnection;
    }
}
