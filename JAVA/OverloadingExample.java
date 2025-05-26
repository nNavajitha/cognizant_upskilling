class OverloadingExample {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();
        System.out.println(obj.add(2, 3));
        System.out.println(obj.add(2.5, 3.5));
        System.out.println(obj.add(1, 2, 3));
    }
}
