//Sema Köse
//141044002
//HW3

package company;

public class Person {
    State needingSleepState;
    State graduateState;
    State readyState;
    State fitState;
    State chronicIllnessState;
    State unableToBecomeARodForAnAxeState;

    State state;

    public Person(){
        needingSleepState = new NeedingSleep(this);
        graduateState = new Graduate(this);
        readyState = new Ready(this);
        fitState = new Fit(this);
        chronicIllnessState = new ChronicIllness(this);
        unableToBecomeARodForAnAxeState = new UnableToBecomeARodForAnAxe(this);
        state = readyState;
    }
    public void exercise() {
        state.exercise();
    }
    public void sleep() {state.sleep();}
    public void outTillLate() {
        state.outTillLate();
    }
    public void buyingGTX1080() {
        state.buyingGTX1080();
    }
    public void cheating() {
        state.cheating();
    }
    public void coffeeAndWork() {
        state.coffeeAndWork();
    }
    public void perseveranceAndHardWork() {
        state.perseveranceAndHardWork();
    }
    void setState(State state){
        this.state = state;
    }
    public State getNeedingSleepState(){
        return needingSleepState;
    }
    public State getgraduateState(){
        return graduateState;
    }
    public State getReadyState(){
        return readyState;
    }
    public State getFitState(){
        return fitState;
    }
    public State getChronicIllnessState(){
        return chronicIllnessState;
    }
    public State getUnableToBecomeARodForAnAxeState(){
        return unableToBecomeARodForAnAxeState;
    }

}
