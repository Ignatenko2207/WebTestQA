package org.itstep.service;

import org.itstep.model.Item;

public interface DataExtraction {

    Item getItemFromProductUrl(String url);
}
