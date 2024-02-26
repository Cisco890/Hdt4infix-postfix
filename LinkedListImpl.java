public class LinkedListImpl<T> extends AbstractList<T> {
    private Node<T> head;
    private int size;

    public LinkedListImpl() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(T element) {
        if (head == null) {
            return;
        }

        if (head.value.equals(element)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(element)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
