//Sema Köse
//141044002
//HW3

package company;

public class Fit implements State {
    Person person;
    public Fit(Person person){
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
        System.out.println("You've already exercised! You can't exercise twice.\n");
    }

    @Override
    public void sleep() {
        System.out.println("You don't need sleep.\n");
    }

    @Override
    public void outTillLate() {
        System.out.println("You can't go out till late at this state.\n");
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

        System.out.println("You don't need coffee and work.\n");
    }
}
