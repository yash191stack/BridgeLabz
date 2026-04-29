class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String t, String d, int y, double r) {
        title = t; director = d; year = y; rating = r;
    }
}

class MovieList {
    Movie head, tail;

    void addEnd(String t, String d, int y, double r) {
        Movie m = new Movie(t, d, y, r);

        if (head == null) {
            head = tail = m;
            return;
        }

        tail.next = m;
        m.prev = tail;
        tail = m;
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title);
            temp = temp.prev;
        }
    }
}