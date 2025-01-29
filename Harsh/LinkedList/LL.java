public class LL
{
    class Node
    {
        int data;
        Node next;

        Node(int value)
        {
            this.data = value;
            this.next = null;
        }
    }
    Node head;
    void add(int value)
    {
        Node n = new Node(value);

        if(head == null)
            head = n;
        else
        {
            Node current = head;
            while(current.next != null)
                current = current.next;
            
            current.next = n;
        }
    }
    void traverse()
    {
        Node current = head;
        if(current == null)
        {
            System.out.println("Linked list is empty!");
            return;
        }
        
        
        System.out.print("Head --> ");

        while(current != null)
        {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");

    }
    void addStart(int value)
    {
        Node n = new Node(value);

        Node x = head;
        if(x == null)
        {
            head = n;
            return;
        }
        head = n;
        head.next = x;
    }
    void deleteLastNode()
    {
        Node x = head;
        if(head == null)
        {
            System.out.println("The list is empty and has no nodes to delete");
            return;
        }
        else if(head.next == null)
        {
            int data = head.data;
            head = null;
            System.out.println("Node having data: "+data+" have been deleted");
            return;
        }
        while(x.next.next != null)
            x = x.next;
        int data = x.data;
        x.next = null;
        System.out.println("Node having data: "+data+" have been deleted");
        
    }
    void deleteFirstNode()
    {
        if(head == null)
        {
            System.out.println("The list is empty and has no nodes to delete");
            return; 
        }
        int data = head.data;
        head = head.next;
        System.out.println("Node having data: "+data+" have been deleted");
    }
    int count()
    {
        int k=0;
        if(head == null)
            return 0;
        Node x = head;
        while (x != null) 
        {
            k++;
            x = x.next;
        }
        return k;

    }
    public static void main(String args[])
    {
        LL list = new LL();
        list.traverse();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.addStart(50);
        list.traverse();
        System.out.println(list.count());


        list.deleteLastNode();
        list.traverse();

        list.deleteFirstNode();
        list.deleteFirstNode();
        list.deleteFirstNode();list.deleteFirstNode();
        list.traverse();
    }
}