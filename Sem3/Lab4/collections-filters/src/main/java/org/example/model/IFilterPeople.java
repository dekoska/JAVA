package org.example.model;

import org.example.queries.search.SearchParameters;

import java.util.List;

public interface IFilterPeople{
    public void setSearchParameters(SearchParameters searchParams);
    public boolean canFilter();
    public List<Person> filter(List<Person> items);
}
