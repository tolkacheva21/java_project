package ru.tolkacheva.main;

import ru.tolkacheva.animals.*;
import ru.tolkacheva.birds.*;
import ru.tolkacheva.differentclasses.Box;
import ru.tolkacheva.differentclasses.Stack;
import ru.tolkacheva.differentclasses.Storage;
import ru.tolkacheva.geometry.*;
import ru.tolkacheva.karate.*;
import ru.tolkacheva.people.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setObj(3);
        System.out.println(box.getObj());

        Storage<Integer> st1 = new Storage<>(null);
        System.out.println(st1.getObj(0));
        Storage<Integer> st2 = new Storage<>(99);
        System.out.println(st2.getObj(-1));
        Storage<String> st3 = new Storage<>(null);
        System.out.println(st3.getObj("default"));
        Storage<String> st4 = new Storage<>("hello");
        System.out.println(st4.getObj("hello world"));

        Student std1 = new Student("A", 5, 5, 4);
        Student std2 = new Student("A", 5, 3, 2);
        System.out.println(std2.compare(std1));

        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(3, 4, 5);
        Line<Point3D> line = new Line<>(p1, p2);
        System.out.println(line);

        Stack<Point> stack = new Stack<>();
        stack.push(p1);
        stack.push(p2);
        stack.peek();
    }

    public static void test(Meowable meowable){
        meowable.meow();
        meowable.meow();
    }

    public static void addMany(List<Student> stds, int x) {
        int i = 0;
        try {
            for (; i < stds.size(); i++){
                stds.get(i).setMarks(List.of(x));
            }
        } catch (IllegalGradeException e){
            for (int j = i - 1; j >= 0; j--){
                stds.remove(stds.get(j));
            }
        }
    }

    public static double sumNum(Number... num){
        double res = 0;
        for (Number x: num){
            res += x.doubleValue();
        }
        return res;
    }

    public static void singer(Bird... bird){
        for (Bird b: bird) b.sing();
    }

    public static double uniteArea(Figure... figures){
        double res = 0;
        for (Figure f: figures){
            res += f.figureArea();
        }
        return res;
    }

    public static void superMeow(Meowable... cats){
        for (Meowable c: cats) c.meow();
    }

    public static long superLen(Lengthable... lines){
        long res = 0;
        for (Lengthable l: lines){
            res += l.lengthLine();
        }
        return res;
    }

    public static List<Polyline> getUnitePolyline(PolylineGetable... objects){
        List<Polyline> polylineList = new ArrayList<>();
        for (PolylineGetable obj: objects){
            polylineList.add(obj.getPolyline());
        }
        return polylineList;
    }

    public static double myPow(String x, String y){
        int x1 = parseInt(x);
        int y1 = parseInt(y);
        return pow(x1, y1);
    }
}