class Process {
    int id, burst;
    Process next;

    Process(int i, int b) {
        id = i; burst = b;
    }
}

class RoundRobin {
    Process head;

    void add(int id, int burst) {
        Process p = new Process(id, burst);

        if (head == null) {
            head = p;
            p.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = p;
        p.next = head;
    }

    void execute(int quantum) {
        Process temp = head;

        while (temp != null) {
            if (temp.burst > 0) {
                int exec = Math.min(quantum, temp.burst);
                temp.burst -= exec;
                System.out.println("Process " + temp.id + " executed");
            }

            temp = temp.next;

            if (temp == head) break;
        }
    }
}