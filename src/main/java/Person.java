import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return getAddress().isPresent();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(this.age);
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(this.address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) this.age++;
        else throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(this.address);
    }
}