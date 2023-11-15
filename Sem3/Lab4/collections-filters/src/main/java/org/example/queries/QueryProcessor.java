package org.example.queries;

import org.example.model.ICalculate;
import org.example.model.ICutToPage;
import org.example.model.IFilterPeople;
import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    private List<IFilterPeople> filter = new ArrayList<>();
    private List<ICalculate> calculators = new ArrayList<>();
    private ICutToPage pageCutterr;

    public QueryProcessor addFilter(IFilterPeople filters){
        this.filter.add(filters);
        return this;
    }

    public QueryProcessor addCalculation(ICalculate calculator){
        this.calculators.add(calculator);
        return this;
    }

    public QueryProcessor addPageCutter(ICutToPage pageCutter){
        this.pageCutterr=pageCutter;
        return this;

    }


    public Results GetResults(SearchParameters parameters, List<Person> data){
        Results result = new Results();
        List<Person> data1 = new ArrayList<>(data);

        for (IFilterPeople filterPeople : filter){
            filterPeople.setSearchParameters(parameters);
            if(filterPeople.canFilter())
                data1 = filterPeople.filter(data1);
        }

        result.setItems(data1);

        for (ICalculate calculate : calculators){
            List<FunctionsParameters> functionsParameters = parameters.getFunctions();
            List<FunctionResult> functionResults = new ArrayList<>();

            for (FunctionsParameters function : functionsParameters) {
                FunctionResult result1 = new FunctionResult();

                result1.setFunction(function.getFunction());
                result1.setFieldName(function.getFieldName());
                result1.setValue(calculate.calculate(function,data));

                functionResults.add(result1);
            }
            result.setFunctionResults(functionResults);
        }
        result.setItems(pageCutterr.cut(parameters.getPage(),data1));
        result.setPages(parameters.getPage().getPageNumber());
        result.setCurrentPage(( parameters.getPage().getPageNumber() *  parameters.getPage().getSize()) / parameters.getPage().getSize());

        return result;
    }


}
