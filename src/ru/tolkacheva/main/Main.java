package ru.tolkacheva.main;

import ru.tolkacheva.animals.*;
import ru.tolkacheva.birds.*;
import ru.tolkacheva.boxes.Box;
import ru.tolkacheva.functional.DataStream;
import ru.tolkacheva.functional.Supplier;
import ru.tolkacheva.geometry.*;
import ru.tolkacheva.people.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Line<Point> line1 = Line.of(1, 2, 3, 4);
        moveLineX(line1);
        System.out.println(line1);

        Box<Integer> box1 = new Box<>();
        Box<Double> box2 = new Box<>();
        Box<Integer> box3 = new Box<>();
        box1.setObj(1);
        box2.setObj(-3.4);
        box3.setObj(8);
        System.out.println(maxBox(List.of(box1, box2, box3)));

        Box<Point3D> box4 = new Box<>();
        putPoint3D(box4);
        System.out.println(box4.getObj());

        List<Number> lst = new ArrayList<>();
        lst.add(3.3);
        putNumbers(lst);
        System.out.println(lst);

//        List<Integer> list1 = List.of(1, -3, 7);
//        DataStream.collect(list1, a -> new ArrayList<>(), a, b -> a.add(b));
    }

    public static void putNumbers(List<Number> list){
        for (int i = 1; i <= 100; i++){
            list.add(i);
        }
    }

    public static void putPoint3D(Box<Point3D> box) {
        box.setObj(new Point3D((int) (Math.random()*11), (int) (Math.random()*11), (int) (Math.random()*11)));
    }

    public static double maxBox(List<Box<? extends Number>> boxes){
        double max = 0;
        if (boxes.get(0) != null) max = boxes.get(0).getObj().doubleValue();
        for (Box<? extends Number> x: boxes.subList(1, boxes.size())){
            double temp = x.getObj().doubleValue();
            if (x != null && temp > max){
                max = temp;
            }
        }
        return max;
    }

    public static void moveLineX(Line<? extends Point> line){
        line.getPoint1().x = line.getPoint1().x + 10;
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