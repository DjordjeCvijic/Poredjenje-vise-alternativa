package model;

public class Table {

    private static int numOfAlternatives;
    public static Alternative [] alternatives;
    public static Float[] effects;
    public static float avrVelueOfTable;

    public Table(){}

    public static void setTable(int n){
        numOfAlternatives=n;
        alternatives=new Alternative[numOfAlternatives];
        for(int i=0;i<numOfAlternatives;i++){
            alternatives[i]=new Alternative(i);
        }

        effects=new Float[numOfAlternatives];

    }

    public static void calc(){
        
    }

}
