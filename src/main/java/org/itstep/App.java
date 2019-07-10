package org.itstep;

import org.itstep.service.DataExtraction;
import org.itstep.service.PromDataExtraction;


public class App 
{
    public static void main( String[] args )
    {
        String url = "https://prom.ua/p843085994-noutbuk-omen-dc0047ur.html";
        DataExtraction promExtraction = new PromDataExtraction();

        System.out.println( promExtraction.getItemFromProductUrl(url).getName() );
    }
}
