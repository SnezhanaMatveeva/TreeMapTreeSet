import java.util.Comparator;

public class PersonsNameLengthComparator implements Comparator<Person> {
    private int maxCount;

    public PersonsNameLengthComparator(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public int compare(Person object1, Person object2) {
        String[] surnames1 = object1.getSurname().split("\\P{IsAlphabetic}+");
        int person1Count = surnames1.length;
        String[] surnames2 = object2.getSurname().split("\\P{IsAlphabetic}+");
        int person2Count = surnames2.length;
        if (person1Count > person2Count && person1Count<=maxCount) {
            return -1;
        } else if (person1Count < person2Count && person2Count<=maxCount){
            return 1;
        } else {
            return compareAge(object1.getAge(), object2.getAge());
        }
    }

    private int compareAge(int personAge1, int personAge2) {
        if (personAge1 > personAge2) {
            return -1;
        } else if (personAge1 < personAge2) {
            return 1;
        }
        return 0;
    }
}

