package realtimeAssignment1;

public class stuNoSubAcc extends Thread {
    String studNoSub[][];

    stuNoSubAcc(String studNoSub[][]){
        this.studNoSub=studNoSub;

    }

    @Override
    public void run() {
        System.out.println("List of students who have not submitted Github account");
        System.out.println("| No. | Matric | Name                                  |");
        System.out.println("|-----|--------|---------------------------------------|");
        for(int i=0;i<studNoSub.length;i++){
            System.out.printf("|%-5s|%-8s|%-39s|\n",i+1,studNoSub[i][1],studNoSub[i][2]);
        }
        System.out.println("|-----|--------|---------------------------------------|");
    }
}
