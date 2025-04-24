package ru.tolkacheva.spring.databases;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.function.Function;

@Component
public class DAO {
    private Connection connection;
    private Map<Class<?>, Function> converters = new HashMap<>();

    public DAO(Connection connection, Map<Class<?>, Function> converters) {
        this.connection = connection;
        this.converters = converters;
    }

    public void findAllByName(String name) {}

    public <T> List<T> findAll(Class<T> clz) {
        List<T> res = new ArrayList<>();

        Map<String, Method> setter = new HashMap<>();
        for (Method m: clz.getDeclaredMethods()) {
            if (m.getName().startsWith("set")) {
                setter.put(m.getName().toLowerCase(), m);
            }
        }

        String queryParam = "";
        List<Field> fields = List.of(clz.getDeclaredFields());
        for (int i = 0; i < fields.size(); i++) {
            if (i == fields.size() - 1){
                break;
            }
            queryParam += fields.get(i).getName() + ", ";
        }
        queryParam += fields.getLast();

        try (PreparedStatement statement = connection.prepareStatement("select (?) from (?)")) {
            String table = clz.getSimpleName();
            statement.setString(1, queryParam);
            statement.setString(2, table);
            try (ResultSet data = statement.executeQuery()) {
                while (data.next()) {
                    T newObj = clz.getDeclaredConstructor().newInstance();
                    for (Field f: fields){
                        //f.setAccessible(true);
                        String column = f.getName();
                        if (f.isAnnotationPresent(Column.class)) {
                            column = f.getAnnotation(Column.class).value();
                        }
                        Object columnRes = converters.get(f.getType()).apply(data.getString(column));
                        if (setter.containsKey("set" + f.getName())) {
                            setter.get("set" + f.getName()).invoke(newObj, columnRes);
                        }
                        //f.set(newObj, columnRes);
                    }
                    res.add(newObj);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
