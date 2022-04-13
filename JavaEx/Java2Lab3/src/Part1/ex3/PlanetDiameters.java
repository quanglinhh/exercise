package Part1.ex3;


import java.util.*;

public class PlanetDiameters {
   //array of planet's name
    private static String[] names = {"Mercurry","Venus","Earth","Mard","Jupiter","Saturn","Uranus","Neptune","Pluto"};

    //array of planet's diameter
    private static float[] diameters ={4800f, 12103.6f, 12756.3f, 6794f, 142984f, 120536f,51118f, 49532f,2274f};

    public static void main(String[] args) {
        //Use Map to store planet's mame and their corresponding
        //diameters.
        Map planets = new HashMap();

        //Add items (key, value) to the map
        for(int i = 0; i < names.length;i++){
            planets.put(names[i], diameters[i]);
        }
        //Traverse the map
        Iterator it = planets.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + ": "+ e.getValue());
        }
        System.out.println("--------------------");

        //Find a planet by name basing on key
        while(true){
            System.out.print("Find planet (ENTER to quit): ");
            String name = (new Scanner(System.in)).nextLine();
            if(name.length() == 0) break;
            if(!planets.containsKey(name))
                System.out.println("Planet " + name + " not found!");
            else
                System.out.println("The diameter of "+ name + " is"+ planets.get(name));
        }
    }
}
