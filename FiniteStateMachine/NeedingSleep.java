//Sema Köse
//141044002
//HW3

package company;

public class NeedingSleep implements State {
    Person person;
    public NeedingSleep(Person person){
        this.person = person;
    }
    @Override
    public void perseveranceAndHardWork() {
        System.out.println("You're too sleepy for working.\n");
    }

    @Override
    public void exercise() {
        System.out.println("You're too sleepy for exercise.\n");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping...\n");
        System.out.println("You're ready for working.\n");
        person.setState(person.getReadyState());
    }

    @Override
    public void outTillLate() {
        System.out.println("You're too sleepy for out.\n");
    }

    @Override
    public void buyingGTX1080() {
        System.out.println("You can't buy a GTX1080 at this state.\n");
    }

    @Override
    public void cheating() {
        System.out.println("You can't cheat at this state.\n");
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You've been chronically sick because of caffeine.\n");
        person.setState(person.getChronicIllnessState());
    }
}
