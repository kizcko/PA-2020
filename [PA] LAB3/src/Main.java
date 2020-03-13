import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(10);
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);

        List<Item> items = new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(food1);
        items.add(food2);
        items.add(weapon);


        Greedy greedy = new Greedy(items,knapsack);
        System.out.println(greedy);

        //Dynamic dynamic =new Dynamic(items,knapsack);
        //System.out.println(dynamic);

        Knapsack knapsack1 = new Knapsack();
        List<Item> items1 = new ArrayList<>();
        Generator generator=new Generator(items1,knapsack1);
        System.out.println(knapsack1);

    }

}
