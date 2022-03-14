public class Templature {
    private  double c;

    public Templature(){

        this.c = 25;
    }
    public Templature(double c){

        this.c = c;
    }
    public void setCTemp(double c){
        this.c = c;
    }
    public double getCTemp(){
        System.out.println("Nhiet do theo do C la: "+this.c);
        return this.c;
    }
    public double getKTemp(){
        System.out.println("Nhiet do theo do K la: "+(this.c+ 273.15));
        return (this.c+ 273.15);
    }
    public double getFTemp(){
        System.out.println("Nhiet do theo do F la: "+(this.c+9/5+32));
        return (this.c+9/5+32);
    }
}
