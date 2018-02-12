//Sema Köse
//141044002
//HW3

package company;

public class Ready implements State {
    Person person;
    public Ready(Person person){
        this.person = person;
    }
    @Override
    public void perseveranceAndHardWork() {
        System.out.println("Perseverance and hard working...\n");
        System.out.println("Congratulations, you have been graduated :)\n");
        person.setState(person.getgraduateState());
    }

    @Override
    public void exercise() {
        System.out.println("Exercising...\n");
        person.setState(person.getFitState());
    }

    @Override
    public void sleep() {
        System.out.println("You don't need sleep.\n");
    }

    @Override
    public void outTillLate() {
        System.out.println("Out till late...\n");
        person.setState(person.getNeedingSleepState());
    }

    @Override
    public void buyingGTX1080() {
        System.out.println("Buying a GTX1080...\n");
        System.out.println("You're officially unable to become a rod for an axe!\n");
        person.setState(person.getUnableToBecomeARodForAnAxeState());
    }

    @Override
    public void cheating() {
        System.out.println("Cheating...\n");
        System.out.println("You're officially unable to become a rod for an axe!\n");
        person.setState(person.getUnableToBecomeARodForAnAxeState());
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You don't need coffee and work.\n");
    }
}
