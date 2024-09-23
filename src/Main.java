public class Main {
    public static void main(String[] args) {
        /*Human man1 = new Human("Cleopatra", 152);
        Human man2 = new Human("Pushkin", 167);
        Human man3 = new Human("Vladimir", 189);
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(man3);*/

        /*Name name1 = new Name("Cleopatra", null, null);
        Name name2 = new Name("Pushkin", "Alexandr", "Sergeevich");
        Name name3 = new Name("Mayakovskiy", "Vladimir", null);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);*/

        /*Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);*/

        /*House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);*/

        Dot point1 = new Dot(1, 3);
        Dot point2 = new Dot(23, 8);
        Dot point3 = new Dot(5, 10);
        Dot point4 = new Dot(25, 10);
        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point3, point4);
        Line line3 = new Line(point1, point4);
        point1.y = 5;
        point3.x = 7;
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
    }
}