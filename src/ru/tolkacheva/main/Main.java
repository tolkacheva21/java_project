package ru.tolkacheva.main;

import ru.tolkacheva.animals.*;
import ru.tolkacheva.birds.*;
import ru.tolkacheva.differentclasses.Fraction;
import ru.tolkacheva.geometry.*;
import ru.tolkacheva.people.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fraction fr1 = new Fraction(1, 2);
        Fraction fr2 = fr1.clone();
        System.out.println(fr2);

        Point p1 = new Point(1, 2);
        Point p2 = p1.clone();
        System.out.println(p2);

        Line l1 = new Line(1, 2, 3, 4);
        Line l2 = l1.clone();
        System.out.println(l2);
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