public class NewClass {

    public static void main(String[] args) {

        System.out.println("Hello, it sounds and look interesting ");

        Changes changes = Changes.NONE;
        Person angel = new AngelZahariev();

        angel.setIsHapphy(true);//current state

        if (changes == Changes.NEGATIVE) {
            angel.setIsHapphy(false);
            angel.lookForOpportunities();
            System.out.println("I am interested! ");
        } else if ((changes == Changes.POSITIVE || changes == Changes.NONE) && angel.isHappy()) {
            angel.stayAndWork();
            System.out.println("Thank you for your interest in me!");
            System.out.println("Best Regards!");
        }
    }
}
