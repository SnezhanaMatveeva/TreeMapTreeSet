import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("Александр", "Иванов", 35);
        Person person2 = new Person("Али", "Абу ибн Сина", 40);
        Person person3 = new Person("Михаил", "Михайлов", 36);
        Person person4 = new Person("Петр", "Иванов-Петров-Сидоров", 35);
        Person person5 = new Person("Кирилл", "Сидоров", 15);
        Person person6 = new Person("Федор", "Петров", 10);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        Comparator<Person> personComparator = (object1, object2) -> {
            String[] surnames1 = object1.getSurname().split("\\P{IsAlphabetic}+");
            int person1Count = surnames1.length;
            String[] surnames2 = object2.getSurname().split("\\P{IsAlphabetic}+");
            int person2Count = surnames2.length;
            int maxCount = 3;
            if (person1Count > person2Count && person1Count <= maxCount) {
                return -1;
            } else if (person1Count < person2Count && person2Count <= maxCount) {
                return 1;
            } else {
                return compareAge(object1.getAge(), object2.getAge());
            }
        };

        Collections.sort(people, personComparator);
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static int compareAge(int personAge1, int personAge2) {
        if (personAge1 > personAge2) {
            return -1;
        } else if (personAge1 < personAge2) {
            return 1;
        }
        return 0;
    }
}


   
