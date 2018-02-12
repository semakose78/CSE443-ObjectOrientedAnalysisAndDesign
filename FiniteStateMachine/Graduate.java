//Sema Köse
//141044002
//HW3

package company;

public class Graduate implements State {
    Person person;

    public Graduate(Person person){
        this.person = person;
    }
    @Override
    public void perseveranceAndHardWork() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void exercise() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void sleep() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void outTillLate() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void buyingGTX1080() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void cheating() {
        System.out.println("You've already been graduated\n");
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You've already been graduated\n");
    }
}
