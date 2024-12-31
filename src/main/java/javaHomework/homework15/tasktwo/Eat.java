package javaHomework.homework15.tasktwo;

import java.util.Date;
import java.util.Objects;

public class Eat {
    private int id;
    private Date loadTime = new Date();
    private Date unLoadTime = new Date();

    public Eat(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public Date getUnLoadTime() {
        return unLoadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Eat eat = (Eat) o;
        return id == eat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Eat{" +
                "id=" + id +
                '}';
    }
}
