package org.example.model;

import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class ByAgeToFilter implements IFilterPeople{
    private SearchParameters searchParams;

    public void setSearchParameters(SearchParameters searchParams){
        this.searchParams=searchParams;
    }
    public boolean canFilter(){
        if(searchParams.getAgeTo()!=0)
            return true;
        return false;
    }
    public List<Person> filter(List<Person> items){
        List<Person> goodAge = new ArrayList<>();
        for(Person person : items){
            if(person.getAge()<=searchParams.getAgeTo()){
                goodAge.add(person);
            }
        }
        return goodAge;
    }
}
