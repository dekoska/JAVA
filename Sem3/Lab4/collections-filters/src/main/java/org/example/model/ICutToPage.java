package org.example.model;


import org.example.queries.search.Page;

import java.util.List;

public interface ICutToPage {
    public List<Person> cut(Page page, List<Person> data);
}
