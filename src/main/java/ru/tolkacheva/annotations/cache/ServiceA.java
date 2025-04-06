package ru.tolkacheva.annotations.cache;

@Cache
public class ServiceA {
    public String method1(String param) {
        return "Hello " + param;
    }

    public int method2(int x, int y) {
        return x + y;
    }
}

@Cache({"method3"}) // Кэшировать только method3
class ServiceB {
    public String method3(String param) {
        return "Bye " + param;
    }
    public int method4(int x) {
        return x * 2;
    }
}

class ServiceC {
    public void method5() {
        System.out.println("Wow");
    }
}
