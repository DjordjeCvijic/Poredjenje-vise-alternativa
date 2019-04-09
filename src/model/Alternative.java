package model;

public class Alternative {

    private int numOfAlternative;
    private int numOfMeasurements = 0;
    private float[] scores;
    private float avrValueOfColumn = 0;
    private float[] errorsInMeasurements;


    public Alternative(int n) {
        numOfAlternative = n;

    }

    public int getNumOfAlternative(){
        return numOfAlternative;
    }
    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public float getErrorInMeasurements(int i) {
            return errorsInMeasurements[i];
    }
    public float getMeasurement(int i){
        return scores[i];
    }

    public float getAvrValueOfColumn() {
        return avrValueOfColumn;
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
    public float sumInColumn(){
        float s=0;
        for(int i=0;i<numOfMeasurements;i++)
            s+=scores[i];
        return s;
    }
    public void allErrors(){
        for(int i=0;i<numOfMeasurements;i++)
            System.out.println(errorsInMeasurements[i]+" ");
    }


}