package part1.ex1;

public class Doctor implements Comparable{

    public Doctor(String name, int task){
        this.name = name;
        this.task = task;
    }

   /**Creates a new instance of Doctor */
   public Doctor(){}
    public int compareTo(Object obj){
       //Create a Doctor object
        Doctor doc = (Doctor) obj;

        int a = 0;
        int b = 0;

        a = this.task;
        b = doc.task;

        //Highest number determines the highest priority for the appointments
        if(a<b) {
            return -1;
        }
        if(a>b) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\nThe Doctor is appointed for = "+ name + "\nThe prority for the appontment is = " + task ;
    }
    private String name = "";
    private int task = 0;
}
