import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Rectangle s = new Rectangle(1, 2, 5, 5);
        System.out.println(s.figureArea());

        Shooter s1 = new Shooter("Shooter1");
        Shooter s2 = new Shooter("Shooter2");
        s2.weapon = new Gun(7);
        Shooter s3 = new Shooter("Shooter3");
        s3.weapon = new MachineGun(30, 3);
        s1.shooting();
        s2.shooting();
        s3.shooting();*/

        City a = new BackToCity("A");
        City b = new City("B");
        City c = new City("C");
        City d = new BackToCity("D");
        City e = new City("E");
        a.addWay(b, 100);
        a.addWay(c, 150);
        b.addWay(c, 120);
        d.addWay(b, 170);
        d.addWay(e, 200);
        e.addWay(c, 140);
    }

    public static double sumNum(Number... num){
        double res = 0;
        for (Number x: num){
            res += (double) x;
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
}