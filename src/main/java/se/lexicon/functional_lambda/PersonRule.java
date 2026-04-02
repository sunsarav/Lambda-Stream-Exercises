package se.lexicon.functional_lambda;

@FunctionalInterface
public interface PersonRule {
    boolean check(Main.Person person);
}
