package org.itstep.service;

import org.itstep.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PromDataExtraction implements DataExtraction{

    @Override
    public Item getItemFromProductUrl(String url) {
        Item item = new Item();

        try {
            Document document = Jsoup.connect(url).get();
            item.setUrl(url);
            item.setName(getName(document));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;
    }

    private String getName(Document document) {
        String name = "";
        name = document.getElementsByTag("h1").first().text();
        return name;
    }
}
