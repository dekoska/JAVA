package org.example.model;

import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class ByNameFilter implements IFilterPeople{
    private SearchParameters searchParams;

    public void setSearchParameters(SearchParameters searchParams){
        this.searchParams=searchParams;
    }
    public boolean canFilter(){
        if(searchParams.getName()!=null)
            return true;
        return false;
    }
    public List<Person> filter(List<Person> items){
        List<Person> goodNames = new ArrayList<>();
        for(Person person : items){
            if(person.getName()==searchParams.getName()){
                goodNames.add(person);
            }
        }
        return goodNames;
    }

}
