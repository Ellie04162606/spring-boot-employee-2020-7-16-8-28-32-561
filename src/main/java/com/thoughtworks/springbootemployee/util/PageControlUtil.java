package com.thoughtworks.springbootemployee.util;

import java.util.ArrayList;
import java.util.List;

public class PageControlUtil<T> {

    public List<T> getData(List<T> data, int page, int pageSize) {
        List<T> resultData = new ArrayList<>();
        int l = data.size() - (page - 1) * pageSize;
        for (int i = l; i < l + pageSize; i++) {
            resultData.add(data.get(i));
        }
        return resultData;
    }

}
