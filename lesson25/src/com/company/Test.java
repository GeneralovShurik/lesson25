package com.company;

public class Test {
    private int value = 0;

    public int getValue() {
        return value;
    }

    // блокируется доступ к классу(Test)
    public static synchronized void test() {

    }

    // если synchronized в методе блокируется доступ целиком к объекту

    public synchronized void inc() {
        this.value++;
    }

    public synchronized void dec() {
        //...
        //...
        //...
        // синхронизация отдельного блока кода внутри метода, а не метода целиком
        // (блокировка блока кода вместо блокировки объекта целиком)

        // locked/unlocked
        // в скобки любого не примитивного типа
        // synchronized (o) => o.state = locked
        // после окончания блока synchronized => o.state = unlocked
        synchronized (this) {
            this.value--;
        }
    }
}
