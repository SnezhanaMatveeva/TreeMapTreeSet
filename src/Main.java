import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("Александр", "Иванов", 35);
        Person person2 = new Person("Али", "Абу ибн Сина", 40);
        Person person3 = new Person("Михаил", "Михайлов", 36);
        Person person4 = new Person("Петр", "Иванов-Петров-Сидоров", 35);
        Person person5 = new Person("Олег", "Олегов", 2);
        Person person6 = new Person("Василий", "Петров-Сидоров", 14);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);

        Predicate<Person> personPredicate = person -> person.getAge() < 18;
        people.removeIf(personPredicate);

        Collections.sort(people, new PersonsNameLengthComparator(3));
        for (Person person : people) {
            System.out.println(person);
        }
    }

}
