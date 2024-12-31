package javaHomework.homework15.tasktwo;

import javaHomework.homework15.taskone.StorageFullException;

import java.util.HashSet;
import java.util.Set;

public class Storage<T> {
    private Set<T> storageSet;

    public Storage() {
        storageSet = new HashSet<>();
    }

    public Set<T> getStorageSet() {
        if (storageSet.isEmpty()) throw new StorageEmptyException("Storage is empty.");
        return storageSet;
    }

    public void addToStorage(T item) {
        if (storageSet.size() == 10) throw new StorageFullException("Storage is full.");
        storageSet.add(item);
        System.out.println(item instanceof Eat ? "Eatable is put at storage - " + ((Eat) item).getLoadTime() :
                "Eatable is put at storage - " + ((Drink) item).getLoadTime());
    }

    public T receiveFromStorageById(int id) {
        for (T item : storageSet) {
            if (item instanceof Eat && ((Eat) item).getId() == id) {
                System.out.println("Eatable is removed from storage - " + storageSet.remove(item));
                System.out.println("Time of receiving eatable from storage " + ((Eat) item).getUnLoadTime());
                return item;
            } else if (item instanceof Drink && ((Drink) item).getId() == id) {
                System.out.println("Drinkable is removed from storage - " + storageSet.remove(item));
                System.out.println("Time of receiving drinkable from storage " + ((Drink) item).getUnLoadTime());
                storageSet.remove(item);
                return item;
            }
        }
        throw new NoSuchItemException("Item is not found.");
    }
}
