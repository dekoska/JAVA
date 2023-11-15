package org.example.model;

import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;

public class GeneralFilter implements IFilterPeople{
    private SearchParameters searchParams;
    private Predicate<SearchParameters> canFilterPredicate;
    private DualPredicate filterDualPredicate;

    public GeneralFilter(Predicate<SearchParameters> canFilterPredicate, DualPredicate filterDualPredicate) {
        this.canFilterPredicate = canFilterPredicate;
        this.filterDualPredicate = filterDualPredicate;
    }

    public void setSearchParameters(SearchParameters searchParams){
        this.searchParams=searchParams;
    }
    public boolean canFilter(){
        return canFilterPredicate.test(searchParams);
    }
    public List<Person> filter(List<Person> items){
        return items.stream().filter(p->filterDualPredicate.check(searchParams,p)).toList();
    }

}
