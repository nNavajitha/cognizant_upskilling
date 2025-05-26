import java.util.*;
class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, "Alice");
        map.put(102, "Bob");
        System.out.print("Enter ID to retrieve name: ");
        int id = sc.nextInt();
        System.out.println("Name: " + map.getOrDefault(id, "Not found"));
    }
}
