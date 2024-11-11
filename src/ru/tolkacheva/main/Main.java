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
        List<Point> pts = new ArrayList<>();
        pts.add(new Point(1, 4));
        pts.add(new Point(7, 8));
        pts.add(new Point(1, 2));
        pts.add(new Point(5, 6));
        pts.sort(new PointComparator());
        System.out.println(pts);
    }

    public static void addMany(List<Student> stds, int x){
        for (Student std: stds){
            std.rule = new RangeRule(2, 5);
            try {
                std.setMarks(List.of(x));
            }catch (IllegalArgumentException e){
                throw new IllegalGradeException(x);
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