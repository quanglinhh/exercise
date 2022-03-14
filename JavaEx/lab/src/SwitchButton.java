public class SwitchButton {
    private boolean stasus;
    private ElectricLamp lamp;

    public SwitchButton(){
        stasus = false;
    }
    public void connectToLamp(ElectricLamp lamp){
        this.lamp = lamp;
    }
    public void swichOff(){
        stasus = false;
    }
    public void swichOn(){
        stasus = true;
    }
}
