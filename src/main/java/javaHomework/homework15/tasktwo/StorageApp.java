package javaHomework.homework15.tasktwo;

public class StorageApp {
    public static void main(String[] args) {
        Storage<Eat> eatStorage = new Storage<>();

//        System.out.println(eatStorage.getStorageSet());
/** Как и положено по заданию вылетит ошибка, что склад пустой */
        eatStorage.addToStorage(new Eat(1));
        eatStorage.addToStorage(new Eat(2));
        eatStorage.addToStorage(new Eat(3));
        eatStorage.addToStorage(new Eat(4));
        eatStorage.addToStorage(new Eat(5));
        eatStorage.addToStorage(new Eat(6));
        eatStorage.addToStorage(new Eat(7));
        eatStorage.addToStorage(new Eat(8));
        eatStorage.addToStorage(new Eat(9));
        eatStorage.addToStorage(new Eat(10));
//        eatStorage.addToStorage(new Eat(11))
/** Что-то в этой жизни да ну делал не могу сказать тут соответственно вылетает ошибка, что склад полный*/
        System.out.println(eatStorage.getStorageSet());
        System.out.println(eatStorage.receiveFromStorageById(1));
        System.out.println(eatStorage.getStorageSet());
//        System.out.println(eatStorage.receiveFromStorageById(13));
/** Ну а тут будет ошибка, что такого предмета нет на складе*/

        Storage<Drink> drinkStorage = new Storage<>();

//        System.out.println(drinkStorage.getStorageSet());
/** Как и положено по заданию вылетит ошибка, что склад пустой */
        drinkStorage.addToStorage(new Drink(1));
        drinkStorage.addToStorage(new Drink(2));
        drinkStorage.addToStorage(new Drink(3));
        drinkStorage.addToStorage(new Drink(4));
        drinkStorage.addToStorage(new Drink(5));
        drinkStorage.addToStorage(new Drink(6));
        drinkStorage.addToStorage(new Drink(7));
        drinkStorage.addToStorage(new Drink(8));
        drinkStorage.addToStorage(new Drink(9));
        drinkStorage.addToStorage(new Drink(10));
//        drinkStorage.addToStorage(new Eat(11))
/** Что-то в этой жизни да ну делал не могу сказать тут соответственно вылетает ошибка, что склад полный*/
        System.out.println(drinkStorage.getStorageSet());
        System.out.println(drinkStorage.receiveFromStorageById(1));
        System.out.println(drinkStorage.getStorageSet());
//        System.out.println(drinkStorage.receiveFromStorageById(13));
/** Ну а тут будет ошибка, что такого предмета нет на складе*/
    }
}
