public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    @Override
    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Недостаточно обязательных полей");
        }

        Person person;
        if (age != null) {
            person = new Person(this.name, this.surname, this.age);
        } else {
            person = new Person(this.name, this.surname);
        }
        person.setAddress(this.address);
        return person;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        }
        throw new IllegalArgumentException("Возраст должен быть >= 0");
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
