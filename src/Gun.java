public class Gun {
    int patrons = 5;

    public Gun(int patrons) {
        this.patrons = patrons;
    }

    public Gun() {}

    public void shoot(){
        if (patrons > 0){
            System.out.println("Bah");
            patrons -= 1;
        }
        else{
            System.out.println("Clac");
        }
    }
}
