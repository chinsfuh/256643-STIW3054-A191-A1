package realtimeAssignment1;

public class Main {
    final String stuInfoLink = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
    final String stuAccLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
    countStu contStuNo;
    countStuAcc contStuAcc;
    getStuList stuList;
    getStuAcc studAcc;
    readstudNoSub sNsub;
    stuSubAcc t1;
    stuNoSubAcc t2;
    stuUnk t3;
    convertExcel t4;
    checkStu validateStu;

    public static void main(String args[]){
        new Main().run();
    }

    public void run(){
        contStuNo = new countStu(stuInfoLink);
        contStuAcc =new countStuAcc(stuAccLink);
        stuList = new getStuList(stuInfoLink,contStuNo.calcStud());
        studAcc =new getStuAcc(stuAccLink,contStuAcc.calcStud());
        studAcc.readData();
        stuList.readData();
        validateStu=new checkStu(studAcc.getghAcc(),stuList.getStudList());
        validateStu.check();
        sNsub =new readstudNoSub(validateStu.getStudValid(),stuList.getStudList());
        t1=new stuSubAcc(validateStu.getStudValid());
        t2=new stuNoSubAcc(sNsub.compare());
        t3=new stuUnk(validateStu.getStudUnknown());
        t4 =new convertExcel(validateStu.getStudValid(),sNsub.getStudNosub(),validateStu.getStudUnknown());
        try {
            t1.run();
            t1.join();
            t2.run();
            t2.join();
            t3.run();
            t3.join();
            t4.run();
            t4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
