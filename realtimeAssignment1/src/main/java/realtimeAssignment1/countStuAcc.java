package realtimeAssignment1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class countStuAcc {
    private String link;
    private Document doc;
    private int total=0;
    private final String myString = "\\d{5,6}";
    private RegexMatches regexMatches;

    countStuAcc(String githubLink){
        this.link=githubLink;
    }

    public int calcStud(){
        regexMatches = new RegexMatches();
        try {
            doc = Jsoup.connect(link).get();

            // get students who submitt github account
            Elements links = doc.select("p");
            for (Element link : links) {
                String theLink = link.text();
                if (regexMatches.isMatch(myString, theLink) == true) {
                    total++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

}
