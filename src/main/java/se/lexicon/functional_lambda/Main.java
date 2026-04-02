package se.lexicon.functional_lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
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

        // Defining rules using Lambdas : boolean check(Person person);
        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule livesInStockholm = person -> person.getCity().equals("Stockholm");

        // Filtering people
        List<Person> activePeople = filterPeople(people, isActive);
        List<Person> adultPeople = filterPeople(people, isAdult);
        List<Person> stockholmPeople = filterPeople(people, livesInStockholm);

        System.out.println();
        System.out.println("Active People are: " + activePeople);
        System.out.println("Adult People are: " + adultPeople);
        System.out.println("Stockholm People are: " + stockholmPeople);

        // Defining actions using Lambdas: void run(Person action);
        PersonAction printName = action -> System.out.println("Person's Name: " + action.getName());
        PersonAction sendEmail = action -> System.out.println("Send email to: " + action.getName());

        System.out.println("\n--- Persons those who are Active ---");
        applyAction(activePeople, printName);

        System.out.println("\n--- Persons those who are Adults ---");
        applyAction(adultPeople, printName);

        System.out.println("\n---Persons those who are living in Stockholm");
        applyAction(stockholmPeople, sendEmail);


    }

    public static List<Person> filterPeople(List<Person> people, PersonRule rule) {
        List<Person> filteredList = new ArrayList<>();
        for (Person person : people) {
            if (rule.check(person)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    public static void applyAction(List<Person> people, PersonAction action) {
        for (Person person : people) {
            action.run(person);
        }
    }
}
