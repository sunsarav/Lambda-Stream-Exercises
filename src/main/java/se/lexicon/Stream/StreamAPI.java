package se.lexicon.Stream;

import se.lexicon.functional_lambda.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamAPI {
    void main() {
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        System.out.println("\n--- Person List ---");

        // Iterating through the list
        for (Person person : people) {
            System.out.println(person);
        }

        // Filter all active people
        System.out.println("Here comes the list of active people");
        List<Person> activePeople = people.stream()
                .filter(person -> person.isActive())
                .toList();
        System.out.println("Active People(Stream): " + activePeople);

        // Map all Names
        System.out.println();
        List<String> names = people.stream()
                .map(person -> person.getName())
                .toList();
        System.out.println("All Names: " + names);

        // Count Adults
        System.out.println();
        long adultCount = people.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println("Number of Adults: " + adultCount);

        // Sort by Age
        System.out.println();
        List<Person> age = people.stream()
                .sorted(Comparator.comparing(person -> person.getAge()



        // First active person in Stockholm
        System.out.println();

        Optional<Person> firstStockholmActive = people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getCity().equals("Stockholm"))
                .findFirst();
        System.out.println("First active person in Stockholm: " + firstStockholmActive);


    }
}
