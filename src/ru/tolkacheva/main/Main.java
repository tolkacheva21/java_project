package ru.tolkacheva.main;

import ru.tolkacheva.animals.*;
import ru.tolkacheva.birds.*;
import ru.tolkacheva.boxes.Box;
import ru.tolkacheva.functional.BiConsumer;
import ru.tolkacheva.functional.Supplier;
import ru.tolkacheva.geometry.*;
import ru.tolkacheva.people.*;
import ru.tolkacheva.trafficlight.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrafficLight tf = new TrafficLight();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
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
        line.getPoint1().x = line.getPoint1().x + 5;
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

class ListSupplier implements Supplier<List<List<Integer>>>{

    @Override
    public List<List<Integer>> get() {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }
}

class ListConsumer implements BiConsumer<List<List<Integer>>, Integer>{
    @Override
    public void accept(List<List<Integer>> collection, Integer value) {
        if (value > 0) collection.get(0).add(value);
        else collection.get(1).add(value);
    }
}