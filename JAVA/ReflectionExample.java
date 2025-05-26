import java.lang.reflect.*;
class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Sample");
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName());
        }
    }
}
