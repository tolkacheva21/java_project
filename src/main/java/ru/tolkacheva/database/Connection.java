package ru.tolkacheva.database;

public class Connection {
    private Database database;

    public Connection(Database database) {
        if (database.getCurConnection() < database.getMaxConnection()) {
            this.database = database;
            this.database.addCurConnection();
        }
    }

    public String getData(int index){
        if (database.getData().get(index).isEmpty()) return null;
        return database.getData().get(index);
    }

    public void addData(String data){
        database.getData().add(data);
    }

    @Override
    public String toString() {
        if (database == null) return "Database isn't active";
        return "Database is active";
    }
}
