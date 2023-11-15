package org.example.model;

import org.example.queries.search.SearchParameters;

public interface DualPredicate {
    public boolean check(SearchParameters searchParams, Person person);
}
