import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public Generator(List<Item> items,Knapsack knapsack) {
        List<Item> itemsTemp = new ArrayList<>();
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);
        Weapon weapon2 = new Weapon(Weapon.WeaponType.PISTOL, 1, 4);
        Weapon weapon3 = new Weapon(Weapon.WeaponType.RIFLES, 8, 10);
        itemsTemp.add(book1);
        itemsTemp.add(book2);
        itemsTemp.add(food1);
        itemsTemp.add(food2);
        itemsTemp.add(weapon);
        itemsTemp.add(weapon2);
        itemsTemp.add(weapon3);


        Random rand= new Random();

        for (int i =0; i< 7;i++){
            int randomIndex = rand.nextInt(itemsTemp.size());
            items.add(itemsTemp.get(randomIndex));
        }

       int max=12;
        int min=4;

        int randomKnapsack = rand.nextInt((max-min)+1)+min;
        knapsack.setCapacity(randomKnapsack);
        knapsack.setItems(items);



    }

}
