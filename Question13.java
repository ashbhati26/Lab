public class Question13 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head;

        // Method to insert a new node at the end of the circular linked list
        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                head.next = head;  // Pointing back to itself for circular nature
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
            }
        }

        // Method to display the elements of the circular linked list
        public void display() {
            if (head == null) {
                System.out.println("Circular Linked List is empty.");
                return;
            }

            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insert(10);
        circularLinkedList.insert(20);
        circularLinkedList.insert(30);
        circularLinkedList.insert(40);

        System.out.println("Circular Linked List elements:");
        circularLinkedList.display();
    }
}