import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Input reader
        System.out.print("Enter a number: ");
        int num = sc.nextInt(); // Read the number
        for (int i = 1; i <= 10; i++) { // Loop from 1 to 10
            System.out.println(num + " x " + i + " = " + (num * i)); // Print result
        }
        sc.close();
    }
}
