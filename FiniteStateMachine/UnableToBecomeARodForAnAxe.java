//Sema Köse
//141044002
//HW3

package company;

public class UnableToBecomeARodForAnAxe implements State {
    Person person;
    public UnableToBecomeARodForAnAxe(Person person){
        this.person = person;
    }
    @Override
    public void perseveranceAndHardWork() {
        System.out.println("You can't hardwork anymore for graduating.You've been unable to become a rod for an axe already!\n");;
    }

    @Override
    public void exercise() {
        System.out.println("You can't exercise.You've been unable to become a rod for an axe already!\n");
    }

    @Override
    public void sleep() {
        System.out.println("You can't sleep.You've been unable to become a rod for an axe already!\n");
    }

    @Override
    public void outTillLate() {
        System.out.println("You can't out till late.You've been unable to become a rod for an axe already!\n");
    }

    @Override
    public void buyingGTX1080() {
        System.out.println("You can't buy any GTX1080. You've been unable to become a rod for an axe already!\n");
    }

    @Override
    public void cheating() {
        System.out.println("You can't cheat.You've been unable to become a rod for an axe already!\n");
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You can't drink coffee for working.You've been unable to become a rod for an axe already!\n");
    }
}
