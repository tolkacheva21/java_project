package tolkacheva.main;

import tolkacheva.animals.*;
import tolkacheva.birds.*;
import tolkacheva.geometry.*;
import tolkacheva.citiesandways.*;
import tolkacheva.differentclasses.*;
import java.math.BigInteger;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*City a = new BackToCity("A");
        City b = new City("B");
        City c = new City("C");
        City d = new BackToCity("D");
        City e = new City("E");
        a.addWay(b, 100);
        a.addWay(c, 150);
        b.addWay(c, 120);
        d.addWay(b, 170);
        d.addWay(e, 200);
        e.addWay(c, 140);*/

        System.out.println(sumNum(7,
                new tolkacheva.differentclasses.Fraction(11, 3),
                3.21, new BigInteger("12345678912345678912")));
        Point2D p1 = new Point2D(1, 2);
        Point p2 = new Point(3, 4);
        System.out.println(p1);
        System.out.println(p2);
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