public class Time {
    private int sec;

    public Time(int sec) {
        if (sec < 0 || sec > 24 * 3600) throw new IllegalArgumentException("seconds must be positive");
        this.sec = sec;
    }

    public Time(int hours, int minutes, int sec) {
        this(hours * 3600 + minutes * 60 + sec);
        if (hours < 0 || hours > 24 || minutes < 0
                || minutes > 24 * 60 ||
                sec < 0 || sec > 24 * 3600) throw new IllegalArgumentException("time must be positive " +
                "and less 24 hours");
    }

    public int getHours(){
        if ((sec / 3600) / 24 != 0) return sec / 3600 / 24;
        return sec / 3600;
    }

    public int getMinutes(){
        return sec / 60 % 60;
    }

    public int getSeconds(){
        return sec % 60 % 60;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        if (sec < 0  || sec > 24 * 3600) throw new IllegalArgumentException("seconds must be positive");
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
