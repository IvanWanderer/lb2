package ad231.hihlo;

class Item {
    private String name;
    private float price;


    public Item(String name, float price) {
        this.name = name;
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    // повышение цены
    public void increasePrice(float percent) {
        if (percent > 0) {
            price += price * (percent / 100);
        }
    }

    // понижение цены
    public void decreasePrice(float percent) {
        if (percent > 0) {
            price -= price * (percent / 100);
            if (price < 0) {
                price = 0;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}

class Cart {
    private Item[] items;
    private int top;
    private int capacity;

    public Cart(int capacity) {
        this.capacity = capacity;
        this.items = new Item[capacity];
        this.top = -1;
    }

    public void addItem(Item item) {
        if (top == capacity - 1) {
            System.out.println("Кошик переповнений!");
        } else {
            items[++top] = item;
        }
    }

    public float getTotalPrice() {
        float total = 0;
        for (int i = 0; i <= top; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void increaseAllPrices(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].increasePrice(percent);
        }
    }

    public void decreaseAllPrices(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].decreasePrice(percent);
        }
    }
}

public class task1_2_3 {
    public static void main(String[] args) {
        // создаётся корзина для 6 товаров
        Cart cart = new Cart(6);

        cart.addItem(new Item("Apple", 10));
        cart.addItem(new Item("Banana", 15));
        cart.addItem(new Item("Orange", 20));
        cart.addItem(new Item("Grapes", 30));
        cart.addItem(new Item("Mango", 25));

        System.out.println("Загальна ціна товарів у кошику: " + cart.getTotalPrice());

        cart.increaseAllPrices(15);
        System.out.println("Підвищення на 15%: " + cart.getTotalPrice());

        cart.decreaseAllPrices(30);
        System.out.println("Зниження на 30%: " + cart.getTotalPrice());
    }
}