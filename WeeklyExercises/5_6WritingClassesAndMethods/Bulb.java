import java.util.Objects;

public class Bulb {
    private String state;

    public Bulb(String state) {
        this.state = state;
    }

    public String isState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String lightSwitch(){
        if (Objects.equals(state, "on")){
            state = "off";
        }
        else{
            state = "on";
        }
        return "This bulb is now " + state;
    }
    @Override
    public String toString() {
        return "This bulb is " + state;
    }
}
class Lights{
    public static void main(String[] args) {
        Bulb bulb1 = new Bulb("on");
        Bulb bulb2 = new Bulb("off");
        Bulb bulb3 = new Bulb("on");

        System.out.println(bulb1);
        System.out.println(bulb2);
        System.out.println(bulb3);

        System.out.println(bulb2.lightSwitch());
    }
}