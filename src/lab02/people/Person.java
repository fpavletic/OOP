package lab02.people;

public abstract class Person {

    private String name = "John Doe";
    private String country = "Noland";
    private int emotion = 50;

    public Person() {
    }

    public Person(String name, String country, int emotion) {
        setName(name);
        setCountry(country);
        setEmotion(emotion);
    }

    private final void setName(String name) {
        if ( name == null ){
            System.err.println("Name must not be null, using default!");
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final void setCountry(String country) {
        if ( country == null ){
            System.err.println("Country must not be null, using default!");
            return;
        }
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public final void setEmotion(int emotion) {
        if ( emotion < 0 || emotion > 100 ){
            System.err.println("Emotion must be between 0 and 100, value unchanged!");
            return;
        }
        this.emotion = emotion;
    }

    public int getEmotion() {
        return emotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return country.equals(person.country);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
