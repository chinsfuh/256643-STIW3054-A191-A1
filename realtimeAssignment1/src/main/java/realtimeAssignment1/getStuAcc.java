package realtimeAssignment1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getStuAcc {
    private final String githubLink;
    private Document doc;
    private String[] ghacc;
    private String[][] ghAcc;
    private RegexMatches regexMatches;
    private final String myString = "\\d{5,6}";
    private String[][] gHAcc;
    getStuAcc(String githubLink, int total){
        this.githubLink=githubLink;
        ghacc=new String[total];
        ghAcc=new String[ghacc.length][];
    }
    public String[][] readData(){
        regexMatches = new RegexMatches();
        try {

            int i=0;
            doc = Jsoup.connect(githubLink).get();


            // get students who submitt github account
            Elements links = doc.select("p");
            for (Element link : links) {
                String theLink = link.text();
                if (regexMatches.isMatch(myString, theLink) == true) {
                    ghacc[i]=theLink.trim();
                    i++;
                }
            }

            for(int j=0;j<ghacc.length;j++){
                ghAcc[j]=ghacc[j].trim().split("Matric:|Name:|Link:|Matric :|Name :|Link :|matrix :|name :|link:|Matric No :|Name|Matric no:");
            }
            for(int a=0;a<ghAcc.length;a++){
                for(int b=0;b<ghAcc[a].length;b++){
                    if((b+1)<ghAcc[a].length){
                        ghAcc[a][b]=ghAcc[a][b+1];
                    }
                }
            }

            for(int o=0;o<ghAcc.length;o++){
                if(ghAcc[o][0].length()>8){
                    if (ghAcc[o][1].length()>=5 && ghAcc[o][1].length()<=8){
                        String str =ghAcc[o][0];
                        ghAcc[o][0]=ghAcc[o][1];
                        ghAcc[o][1]=str;
                    }
                }
            }

            for(int x=0;x<ghAcc.length;x++){
                for(int y=0;y<ghAcc[x].length;y++){
                    ghAcc[x][y]=ghAcc[x][y].trim();
                }
            }

            gHAcc=new String[ghAcc.length][ghAcc[0].length-1];
            for(int x=0;x<ghAcc.length;x++){
                for(int y=0;y<(ghAcc[x].length-1);y++){
                    gHAcc[x][y]=ghAcc[x][y];
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gHAcc;
    }

    public String[][] getghAcc(){
        return gHAcc;
    }
}
