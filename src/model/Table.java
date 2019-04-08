package model;
import java.lang.Math;



public class Table {

    private static int numOfAlternatives;
    public static Alternative [] alternatives;
    public static float[] effects;
    public static float avrVelueOfTable=0;
    public static float sse;
    public static float ssa;
    public static float sst;

    public Table(){}

    public static void setTable(int n){
        numOfAlternatives=n;
        alternatives=new Alternative[numOfAlternatives];
        for(int i=0;i<numOfAlternatives;i++){
            alternatives[i]=new Alternative(i);
        }

        effects=new float[numOfAlternatives];

    }

    public static void calc(){

        int tmp=0;
        for(int i=0;i<numOfAlternatives;i++) {
            avrVelueOfTable += alternatives[i].sumInColumn();
            tmp+=alternatives[i].getNumOfMeasurements();
        }
        avrVelueOfTable/=tmp;

        for(int i=0;i<numOfAlternatives;i++)
            effects[i]=avrVelueOfTable-alternatives[i].getAvrValueOfColumn();

        for(int i=0;i<numOfAlternatives;i++) {
            for (int j = 0; j < Table.alternatives[i].getNumOfMeasurements(); j++) {
                sse += Math.pow(alternatives[i].getErrorInMeasurements(j), 2.0);
            }
        }

        for(int i=0;i<numOfAlternatives;i++)
            ssa+= Math.pow(effects[i],2);
        ssa*=Table.alternatives[0].getNumOfMeasurements();






        System.out.println("apsolutne vijrenosti po kolonama:");
        for(int i=0;i<numOfAlternatives;i++)
            System.out.println( alternatives[i].getAvrValueOfColumn()+" ");

        System.out.println("greske u kolonama su:");
        for(int i=0;i<numOfAlternatives;i++)
            alternatives[i].allErrors();


        System.out.println("srednja vrijednost sistema:");
        System.out.println(avrVelueOfTable);

        System.out.println("efekti:");
        for(int i=0;i<numOfAlternatives;i++)
            System.out.println(effects[i]+" ");


    }

}
