import com.angel.abstractBuilderPattern.NyPizza;
import com.angel.abstractBuilderPattern.Pizza;
import com.angel.builderPattern.Person;
import com.angel.staticFacoryMethodsInsteadOfConstructors.StaticFactoryMethodClass;

public class Application {

    public static void main(String[] args) {
        Person person = new Person.Builder("Pesho", 37)
                                  .setWeight(81.00d)
                                  .setHeight(1.65d)
                                  .build();//that way we create Person object

        NyPizza myPizza = new NyPizza
            .Builder(NyPizza.Size.LARGE)
            .addTopping(Pizza.Topping.MUSHROOM)
            .build();

        StaticFactoryMethodClass staticF = StaticFactoryMethodClass.of("Gosho");

    }

}
