package ru.tolkacheva.sem3.statement;

public class StDepartment {
    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void accept(){
        statement.setAccepted(true);
    }
}
