import com.angel.jpaEntities.User;

public class ModuleFromIntellij {

    User user = new User(1l,"Pesho");//here is dependency project class

    public void hello(){
        System.out.println("Hello");
    }

}
