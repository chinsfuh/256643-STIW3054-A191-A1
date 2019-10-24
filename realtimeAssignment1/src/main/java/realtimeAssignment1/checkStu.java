package realtimeAssignment1;

import java.util.ArrayList;

public class checkStu {
    private String stuSubmit[][];
    private String stuList[][];
    private String stuUnknown[][];
    private String stuUnknown1[][];
    private String stuValid[][];
    int i=0;
    int j=0;

    checkStu(String studSub[][], String studList[][]){
        this.stuSubmit=studSub;
        this.stuList=studList;
    }

    public void check(){
        ArrayList<String> comp = new ArrayList<>();
        ArrayList<String> comp1 = new ArrayList<>();

        for(int x=0;x<stuSubmit.length;x++){
            comp.add(stuSubmit[x][0]);
        }
        for(int x=0;x<stuList.length;x++){
            if(comp.contains(stuList[x][1]))
                comp.remove(stuList[x][1]);
        }
        stuUnknown= new String[comp.size()][];
        for(int x=0;x<stuSubmit.length;x++){
            if(comp.contains(stuSubmit[x][0])){
                stuUnknown[i]=stuSubmit[x];
                i++;
            }
        }

        for(int x=0;x<stuUnknown.length;x++){
            comp1.add(stuUnknown[x][1]);
        }
        for(int x=0;x<stuList.length;x++){
            if(comp1.contains(stuList[x][2])){
                comp1.remove(stuList[x][2]);
            }

        }
        stuUnknown1= new String[comp1.size()][];
        for(int x=0;x<stuUnknown.length;x++){
            if(comp1.contains(stuUnknown[x][1])){
                stuUnknown1[j]=stuUnknown[x];
                j++;
            }
        }
        stuValid=new String[(stuSubmit.length-comp1.size())][];
        int k=0;
        for(int x=0;x<stuSubmit.length;x++){
            if(!comp1.contains(stuSubmit[x][1])){
                stuValid[k]=stuSubmit[x];
                k++;
            }
        }
    }

    public String[][] getStudUnknown(){
        return stuUnknown1;
    }

    public String[][] getStudValid(){
        return stuValid;
    }
}
