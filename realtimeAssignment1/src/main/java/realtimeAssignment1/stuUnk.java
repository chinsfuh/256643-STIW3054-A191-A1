package realtimeAssignment1;

public class stuUnk extends Thread{
    String studUnk[][];
    stuUnk(String studUnk[][]){
        this.studUnk=studUnk;

    }
    @Override
    public void run() {
        System.out.println("List of unknown students who have submitted the Github account.");
        System.out.println("| No. | Matric | Name                                  | GitHub Link                            |");
        System.out.println("|-----|--------|---------------------------------------|----------------------------------------|");
        for(int i=0;i<studUnk.length;i++){
            System.out.printf("|%-5s|%-8s|%-39s|%-40s|\n",i+1,studUnk[i][0],studUnk[i][1],studUnk[i][2]);
        }
        System.out.println("|-----|--------|---------------------------------------|----------------------------------------|");
    }
}
