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
        Collections.sort(persons, new NobilityComparator(5));
        System.out.println(persons);
    }
}
