//Sema Köse
//141044002
//HW3

package company;

public class ChronicIllness implements State {
    Person person;
    public ChronicIllness(Person person){
        this.person = person;
    }
    @Override
    public void perseveranceAndHardWork() {
        System.out.println("You can't harwork. You've been get chronic illness\n");
    }

    @Override
    public void exercise() {
        System.out.println("You can't execise. You've been get chronic illness\n");
    }

    @Override
    public void sleep() {
        System.out.println("You can't sleep.You've been get chronic illness\n");
    }

    @Override
    public void outTillLate() {
        System.out.println("You can't out till late. You've been get chronic illness\n");
    }

    @Override
    public void buyingGTX1080() {
        System.out.println("You can't buy a GTX1080. You've been get chronic illness\n");
    }

    @Override
    public void cheating() {
        System.out.println("You can't cheat anymore. You've been get chronic illness\n");
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You cant dring coffee. You've been get chronic illness\n");
    }
}
