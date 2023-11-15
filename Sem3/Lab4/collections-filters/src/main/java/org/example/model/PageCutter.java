package org.example.model;

import org.example.queries.search.Page;

import java.util.List;

public class PageCutter implements ICutToPage{
    public List<Person> cut(Page page, List<Person> data){
       return data.stream().skip((page.getPageNumber()-1)* page.getSize()).limit(page.getSize()).toList();
    }
}
