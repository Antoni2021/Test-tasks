import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parsing {

    private static int countPages = 0;
    private static int countProducts = 0;

//    Method that returns the page by URL in Document format;
private static Document getPage(String url){
        Document page = null;
        try {
            page = Jsoup.parse(new URL(url), 3000);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        countPages++;
        return page;

    }
    public static void pars(){
        Document page = getPage("https://www.aboutyou.de/maenner/bekleidung");
        Element table = page.select("div[class=ReactVirtualized__Grid__innerScrollContainer]").first();
        Elements names = table.select("a[data-test-id=ProductTile]");
        List<String> list = new ArrayList<>();
        for (Element e : names) {
            list.add("https://www.aboutyou.de" + e.attr("href"));
        }
        List<Map> obj = new ArrayList<>();

        // get information about each product and put it to obj Map
        for (String s : list) {
            Map<String,Object> mapa = new HashMap<>();
            countProducts++;
            Document doc = getPage(s);

            Element elem = doc.select("div[data-test-id=BuyBox]").first();
            String productName = elem.select("div[data-test-id=ProductName]").text();
            mapa.put("Product name", productName);

            String brand = elem.select("div[class=sc-1ybtkva-0 duhYnn]")
                    .first().select("img").attr("alt");
            mapa.put("Brand", brand);

            String price = elem.select("span[class=sc-1kqkfaq-0 x3voc9-0 hztKGd kOcfQo]").text();
            mapa.put("Price", price);

            Elements colors = elem.select("span[class=jlvxcb-1 KCIhX]");
            List<String> colorList = new ArrayList<>();
            for (Element color : colors){
                colorList.add(color.text());
            }
            mapa.put("Colors", colorList);

            elem = doc.select("div[class=d5kk8t-9 RIujM]").first();
            String artNumber = elem.select("p[class=d5kk8t-7 gEmLW]").text().split(" ")[1];
            mapa.put("Article Number", artNumber);

            obj.add(mapa);
        }
        System.out.println("Quantity of opened pages: " + countPages);
        System.out.println("Quantity of received products: " + countProducts);
        Writing.writeFile(obj);
    }

}
