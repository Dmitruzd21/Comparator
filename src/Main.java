import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", "Borovikin", 15));
        persons.add(new Person("Mihail", "Pit", 32));
        persons.add(new Person("Julia", "Very Super Noble", 35));
        persons.add(new Person("Kate", "Best Girl", 52));
        persons.add(new Person("Bred", "Kidman", 27));
        persons.add(new Person("Oliver", "Aganevish", 24));
        persons.add(new Person("Silvia", "Beluchi", 18));
        persons.add(new Person("Viktorya", "Mega Noble Women And Super Pop Star", 33));
        persons.add(new Person("Oleg", "Mega Noble Men And Super Star", 36));

        System.out.println(persons);

        Comparator<Person> comparator1 = (o1, o2) -> {
            String[] o1Array = o1.getSurname().split(" ");
            String[] o2Array = o2.getSurname().split(" ");

            if (o1Array.length > o2Array.length && isMeanToCompareUsingSurname(o1, o2)) {
                return 1;
            } else if (o1Array.length < o2Array.length && isMeanToCompareUsingSurname(o1, o2)) {
                return -1;
            } else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        Collections.sort(persons, comparator1::compare);
        System.out.println(persons);
    }

    public static boolean isMeanToCompareUsingSurname(Person o1, Person o2) {
        int maxNumberOfWordsInSurname = 5;
        String[] o1Array = o1.getSurname().split("\\P{IsAlphabetic}+");
        String[] o2Array = o2.getSurname().split("\\P{IsAlphabetic}+");
        if (o1Array.length < maxNumberOfWordsInSurname && o2Array.length > maxNumberOfWordsInSurname) {
            return true;
        } else if (o1Array.length > maxNumberOfWordsInSurname && o2Array.length < maxNumberOfWordsInSurname) {
            return true;
        } else if (o1Array.length < maxNumberOfWordsInSurname && o2Array.length < maxNumberOfWordsInSurname) {
            return true;
        } else {
            return false;
        }
    }
}
