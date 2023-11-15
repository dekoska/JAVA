package org.example.model;

import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;

import java.util.List;
import java.util.function.Function;

public class GeneralCalculator implements ICalculate{

    private String fieldName;
    private Function<Person, Number> fieldGetter;

    public GeneralCalculator(String fieldName, Function<Person, Number> fieldGetter) {
        this.fieldName = fieldName;
        this.fieldGetter = fieldGetter;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    public double calculate(FunctionsParameters params, List<Person> data){
        if(params.getFunction()== Funcs.AVERAGE){
           return data.stream().mapToDouble(person->fieldGetter.apply(person).doubleValue()).average().orElse(0);
        }
        if(params.getFunction()== Funcs.SUM){
            return data.stream().mapToDouble(person->fieldGetter.apply(person).doubleValue()).sum();
        }
        if(params.getFunction()== Funcs.MIN){
            return data.stream().mapToDouble(person->fieldGetter.apply(person).doubleValue()).min().orElse(0);
        }
        if(params.getFunction()== Funcs.MAX){
            return data.stream().mapToDouble(person->fieldGetter.apply(person).doubleValue()).max().orElse(0);
        }
        return 0;
    }
}
