package pl.lublin.wsei.java.cwiczenia.test;

import pl.lublin.wsei.java.cwiczenia.Infografika;

public class TestInfografika {
    public static void main(String[] args) {
        String tekst="<item>\n" +
        "\t\t\t<title><![CDATA[Infografika - Międzynarodowy Dzień Kobiet 08.03.2022 r.]]></title>\n" +
                "\t\t\t<pubDate><![CDATA[Tue, 08 Mar 2022 08:00:00 +0100]]></pubDate>\n" +
                "\t\t\t<link>https://stat.gov.pl/infografiki-widzety/infografiki/infografika-miedzynarodowy-dzien-kobiet-08-03-2022-r-,25,7.html</link>\n" +
                "\t\t\t<guid isPermaLink=\"false\">https://stat.gov.pl/infografiki-widzety/infografiki/infografika-miedzynarodowy-dzien-kobiet-08-03-2022-r-,25,7.html</guid>\n" +
                "\t\t\t<media:content url=\"https://stat.gov.pl/files/gfx/portalinformacyjny/pl/defaultaktualnosci/5866/25/7/1/dzien_kobiet_2022_pl_3.jpg\" type=\"image/jpeg\" width=\"4267\" height=\"8913\">\n" +
                "\t\t\t\t<media:description type=\"plain\"><![CDATA[]]></media:description>\n" +
                "\t\t\t\t<media:thumbnail url=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/25/7/1/dzien_kobiet_2022_pl_3,k1uUwl-caFOE6tCTiHtf.jpg\" />\n" +
                "\t\t\t</media:content>\n" +
                "\t\t\t<description><![CDATA[<div><img src=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/25/7/1/dzien_kobiet_2022_pl_3,k1uUwl-caFOE6tCTiHtf.jpg\" alt=\"\" width=\"280\" height=\"212\"/></div>]]></description>\n" +
                "\t\t</item>";
        Infografika infografika1 = new Infografika(tekst);



    }


}
