package se.lexicon.functional_programming;

import se.lexicon.functional_programming.Person;
import se.lexicon.functional_programming.PersonRule;

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
        System.out.println("\n--- Persons those who are Active ---");
        System.out.println("Active People are: " + filterPeople(people,isActive));

        PersonRule isAdult = person -> person.getAge() >= 18;
        System.out.println("\n--- Persons those who are Adults ---");
        System.out.println("Adult People are: " +filterPeople(people,isAdult));

        PersonRule livesInStockholm = person -> person.getCity() == "Stockholm";
        System.out.println("\n---Persons those who are living in Stockholm");
        System.out.println("People residing in Stockholm are: " + filterPeople(people,livesInStockholm));

        // Defining actions using Lambdas: void run(Person action);
        PersonAction printName = action -> System.out.println("Person's Name: " +people.g);
        PersonAction sendEmail = action -> System.out.println("Send email to: " +printName)


    }
}

public static List<Person> filterPeople(List<Person> people, PersonRule rule){
    List<Person> filteredList = new ArrayList<>();
        for (Person person : people) {
            if (rule.check(person)) {
                filteredList.add(person);
            }
        }
        return filteredList;
}
