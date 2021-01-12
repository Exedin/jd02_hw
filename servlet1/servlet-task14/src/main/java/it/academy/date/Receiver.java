package it.academy.date;

import java.io.Serializable;
import java.util.Objects;

public class Receiver implements Serializable {

    private int num;
    private String name;

    public Receiver() {
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return num == receiver.num && Objects.equals(name, receiver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
