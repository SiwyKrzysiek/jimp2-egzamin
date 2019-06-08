package zad8_2015;

import java.util.*;

public class ConcurrentStack {
    private Object[] data;
    private int size;
    private int i;

    public ConcurrentStack(int initialSize) {
        size = initialSize;
        data = new Object[initialSize];
    }

    public ConcurrentStack() {
        this(16);
    }

    public synchronized void push(Object o) {
        if (i >= size) {
            size *= 2;
            data = Arrays.copyOf(data, size);
        }

        data[i++] = o;
        notify();
    }

    public synchronized Object pop() {
        if (i <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }

        return data[--i];
    }
}
