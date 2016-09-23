package list_test;


import java.sql.SQLOutput;

public class CustomLinkedList {

    private Node header = new Node(new Node(), new Node(), null);

    static class Node {
        public Node() {
        }

        public Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        private Node next;
        private Node prev;
        private Object value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            if (prev != null ? !prev.equals(node.prev) : node.prev != null) return false;
            return value != null ? value.equals(node.value) : node.value == null;

        }

        @Override
        public int hashCode() {
            int result = next != null ? next.hashCode() : 0;
            result = 31 * result + (prev != null ? prev.hashCode() : 0);
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", prev=" + prev +
                    ", value=" + value +
                    '}';
        }
    }

    public void add(Object o) {
        Node newNode = new Node(header, header.prev, o);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
    }

    public boolean contains(Object o) {
        Node head = header.prev;
        int index=0;

        while (head != null) {
            if (o.equals(head.getValue())){
            System.out.println("Есть совпадение. Индекс: "+index);
                return true;
            }
            index++;
            head = head.prev;
        }
        return false;
    }
    public void remove (Object o) {
        Node head = header.prev;
        int index=0;
        while (head != null) {
            if (o.equals(head.getValue())){
                head.prev.next = head.next;
                head.next.prev = head.prev;
                System.out.println("Удалили объект со следующим индексом"+index);
                break;
            }
            index++;
            head = head.prev;
        }
    }

    public void set (int indexSet, Object newValue){
        Node head = header.prev;
        int index=0;
        outer: while (head != null) {
            if (index == indexSet) {
                System.out.println("Было значение:" + head.getValue());
                head.setValue(newValue);
                System.out.println("Стало значение" + head.getValue());
                head = null;
                break outer;
            }
            index++;
            head = head.prev;
        }
    }

    public void print() {
        Node head = header.prev;

        while (head != null) {
            System.out.println(head.value);
            head = head.prev;
        }
    }
    public CustomLinkedList addAll(CustomLinkedList customLinkedListAdd) {
        customLinkedListAdd.header = this.header.next;
        customLinkedListAdd.header.prev = this.header;
        customLinkedListAdd.print();
        return customLinkedListAdd;
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        for (int i = 0; i < 5; i++) {
            customLinkedList.add(new String ("Node" + i));
        }
        customLinkedList.print();
        customLinkedList.set(2, new String("Node3"));
        customLinkedList.print();
        CustomLinkedList customLinkedList2 = new CustomLinkedList();
        for (int i = 10; i < 15; i++) {
            customLinkedList.add(new String ("Node" + i));
        }
        customLinkedList.addAll(customLinkedList2);

    }
}
