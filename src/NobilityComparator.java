import java.util.Comparator;

public class NobilityComparator implements Comparator<Person> {
    private int maxNumberOfWordsInSurname;

    public NobilityComparator(int maxNumberOfWordsInSurname) {
        this.maxNumberOfWordsInSurname = maxNumberOfWordsInSurname;
    }

    @Override
    public int compare(Person o1, Person o2) {
        String[] o1Array = o1.getSurname().split("\\P{IsAlphabetic}+");
        String[] o2Array = o2.getSurname().split("\\P{IsAlphabetic}+");
        if (o1Array.length > o2Array.length && isMeanToCompareUsingSurname(o1, o2)) {
            return 1;
        } else if (o1Array.length < o2Array.length && isMeanToCompareUsingSurname(o1, o2)) {
            return -1;
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public boolean isMeanToCompareUsingSurname(Person o1, Person o2) {
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

