class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int r, String n, int a, String g) {
        roll = r; name = n; age = a; grade = g;
    }
}

class StudentList {
    Student head;

    void addAtEnd(int r, String n, int a, String g) {
        Student newNode = new Student(r, n, a, g);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void delete(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next != null) temp.next = temp.next.next;
    }

    Student search(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name);
            temp = temp.next;
        }
    }

    void updateGrade(int roll, String grade) {
        Student s = search(roll);
        if (s != null) s.grade = grade;
    }
}