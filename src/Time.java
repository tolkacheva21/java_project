public class Time {
    int sec;

    public Time(int sec) {
        this.sec = sec;
    }

    public String toString(){
        String hours = String.valueOf(sec / 3600);
        String minutes = String.valueOf(sec / 60 % 60);
        String seconds = String.valueOf(sec % 60 % 60);
        if ((sec / 3600) / 10 == 0) hours = "0" + hours;
        else if ((sec / 3600) / 24 != 0) hours = String.valueOf(sec / 3600 / 24);
        if ((sec / 60 % 60) / 10 == 0) minutes = "0" + minutes;
        if ((sec % 60 % 60) / 10 == 0) seconds = "0" + seconds;
        return "Time is " + hours + ":" + minutes + ":" + seconds;
    }
}
