import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> perons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            perons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        long count = perons.stream()
                .filter(s -> s.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> recruitFamilys = perons.stream()
                .filter(s -> s.getSex() == Sex.MAN)
                .filter(s -> s.getAge() > 17 && s.getAge() < 28)
                .map(x -> String.valueOf(x.getFamily()))
                .toList();

        List<Person> productive = perons.stream()
                .filter(s -> s.getAge() > 17 && s.getAge() < 66 && s.getSex() == Sex.MAN && s.getEducation() == Education.HIGHER
                        || s.getAge() > 17 && s.getAge() < 61 && s.getSex() == Sex.WOMAN && s.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .toList();
    }
}