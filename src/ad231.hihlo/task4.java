package ad231.hihlo;

// Реализация очереди вместо стека
class CartTwo {
    private Item[] items;  // хранение товаров
    private int front;     // начало очереди
    private int rear;      // конец очереди
    private int count;     // кол-во элементов в очереди
    private int capacity;  // максимальная вместимость очереди

    public CartTwo(int capacity) {
        this.capacity = capacity;
        this.items = new Item[capacity];
        this.front = 0;  // начало очереди
        this.rear = -1;  // конец очереди
        this.count = 0;  // начально товаров нет
    }

    public void addItem(Item item) {
        if (count == capacity) {
            System.out.println("Кошик переповнений!");
        } else {
            rear = (rear + 1) % capacity;
            items[rear] = item;
            count++;
        }
    }

    public float getTotalPrice() {
        float total = 0;
        for (int i = 0; i < count; i++) {
            total += items[(front + i) % capacity].getPrice();
        }
        return total;
    }

    public void increaseAllPrices(float percent) {
        for (int i = 0; i < count; i++) {
            items[(front + i) % capacity].increasePrice(percent);
        }
    }

    public void decreaseAllPrices(float percent) {
        for (int i = 0; i < count; i++) {
            items[(front + i) % capacity].decreasePrice(percent);
        }
    }
}

public class task4 {
    public static void main(String[] args) {
        CartTwo cart = new CartTwo(6);
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
