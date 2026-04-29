class Task {
    int id;
    String name;
    Task next;

    Task(int i, String n) {
        id = i; name = n;
    }
}

class CircularList {
    Task head;

    void add(int id, String name) {
        Task newNode = new Task(id, name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    void display() {
        if (head == null) return;

        Task temp = head;
        do {
            System.out.println(temp.id);
            temp = temp.next;
        } while (temp != head);
    }
}