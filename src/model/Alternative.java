package model;

public class Alternative {

   private int numOfAlternative;
    private int numOfMeasurements=0;
    private float [] scores;
    private float avrValueOfColumn=0;
    private float [] errorsInMeasurements;


    public Alternative(int n){
        numOfAlternative=n;

    }

     void setNumOfMeasurements(int n){
        numOfMeasurements=n;
    }
    public  void setScores(String sc){
        String[] tmp=sc.split(" ");
        setNumOfMeasurements(tmp.length);//provjeriti
        scores=new float[numOfMeasurements];
        for(int i=0;i<numOfMeasurements;i++){
            scores[i]=Float.parseFloat(tmp[i]);
            avrValueOfColumn+=scores[i];
        }
        avrValueOfColumn/=numOfMeasurements;
        errorsInMeasurements=new float[numOfMeasurements];
        for(int i=0;i<numOfMeasurements;i++){
            errorsInMeasurements[i]=avrValueOfColumn-scores[i];
        }
    }

    public  String print(){
        String rez="";
        int i=0;
        while(i<numOfMeasurements){
        rez+=scores[i++]+ " ";

        }
        return rez;

    }
    public  boolean isEmpty(){
        if(numOfMeasurements==0)return true;
        return false;
    }


}