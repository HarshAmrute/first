import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        // Create a Vector of integers
        Vector<Integer> vector = new Vector<>();

        // Adding elements to the Vector
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        // Printing the elements in the Vector
        System.out.println("Vector elements: " + vector);

        // Accessing elements using index
        System.out.println("Element at index 0: " + vector.get(0));

        // Removing an element at a specific index
        vector.remove(2); // Removes element at index 2

        // Printing the vector after removing an element
        System.out.println("Vector after removal: " + vector);

        // Iterating over the Vector
        System.out.println("Iterating through Vector:");
        for (int i : vector) {
            System.out.println(i);
        }

        // Size of the vector
        System.out.println("Size of the vector: " + vector.size());
    }
}
