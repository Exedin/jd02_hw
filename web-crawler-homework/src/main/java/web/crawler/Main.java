package web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Document document = null; // Can also take an URL.
        List <String> href = new ArrayList<>();
        try {
            document = Jsoup.connect("https://en.wikipedia.org/wiki/Elon_Musk").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (Element element : document.getElementsByTag("a")) {
//            System.out.println(element.attr("href"));
//        }
        for (Element element : document.getElementsByTag("a")) {
            if (element.attr("href").contains("http")||element.attr("href").contains("https")){
                href.add(element.attr("href"));
            }
        }
        for (String s : href) {
            System.out.println(s);

        }


    }
}
