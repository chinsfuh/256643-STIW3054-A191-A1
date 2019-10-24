package realtimeAssignment1;

import java.util.ArrayList;

public class readstudNoSub {
    private String studSub[][];
    private String studList[][];
    private String studNosub[][];
    private String studNosub1[][];
    private int i=0;
    private int j=0;

    readstudNoSub(String studSub[][], String studList[][]){
        this.studSub=studSub;
        this.studList=studList;
    }

    public String[][] compare(){
        ArrayList<String> comp = new ArrayList<String>();
        ArrayList<String> comp1 = new ArrayList<String>();

        for(int x=0;x<studList.length;x++){
            comp.add(studList[x][1]);
        }
        for(int x=0;x<studSub.length;x++){
            if(comp.contains(studSub[x][0]))
                comp.remove(studSub[x][0]);
        }
        studNosub= new String[comp.size()][];
        for(int x=0;x<studList.length;x++){
            if(comp.contains(studList[x][1])){
                studNosub[i]=studList[x];
                i++;
            }
        }

        for(int x=0;x<studNosub.length;x++){
            comp1.add(studNosub[x][2]);
        }
        for(int x=0;x<studSub.length;x++){
            if(comp1.contains(studSub[x][1]))
                comp1.remove(studSub[x][1]);
        }
        studNosub1= new String[comp1.size()][];
        for(int x=0;x<studNosub.length;x++){
            if(comp1.contains(studNosub[x][2])){
                studNosub1[j]=studNosub[x];
                j++;
            }
        }

        return studNosub1;
    }

    public String[][] getStudNosub(){
        return studNosub1;
    }
}