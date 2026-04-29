class Item {
    int id, qty;
    double price;
    String name;
    Item next;

    Item(int i, String n, int q, double p) {
        id = i; name = n; qty = q; price = p;
    }
}

class Inventory {
    Item head;

    void add(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    double totalValue() {
        double sum = 0;
        Item temp = head;

        while (temp != null) {
            sum += temp.qty * temp.price;
            temp = temp.next;
        }
        return sum;
    }
}