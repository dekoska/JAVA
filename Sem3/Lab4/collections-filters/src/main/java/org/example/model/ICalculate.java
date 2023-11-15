package org.example.model;

import org.example.queries.search.FunctionsParameters;

import java.util.List;
import java.util.function.Function;

public interface ICalculate {
    public double calculate(FunctionsParameters params, List<Person> data);
    public String getFieldName();
}
