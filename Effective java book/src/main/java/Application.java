import com.angel.builderPattern.Person;

public class Application {

    public static void main(String[] args) {
        Person person = new Person.Builder("Pesho", 37)
                                  .setWeight(81.00d)
                                  .setHeight(1.65d)
                                  .build();//that way we create Person object

    }

}
