import java.util.List;

record Person(String name, int age) {}

class RecordExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 25),
            new Person("Bob", 17)
        );

        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}
