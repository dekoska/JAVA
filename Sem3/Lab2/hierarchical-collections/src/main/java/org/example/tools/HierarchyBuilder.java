package org.example.tools;

import org.example.Geography;
import org.example.model.SampleGeographiesData;
import org.example.tools.abstractions.IHaveHierarchicalStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class HierarchyBuilder<TItem extends IHaveHierarchicalStructure<TItem>>{
    private List<TItem> elements = new ArrayList<>();
    private TItem rootElement;

    public void setElements(List<TItem> element){
        elements=element;
    }
    public void buildHierarchy() {
        for (TItem geo : elements) { //rodzic
            if(geo.getParentId()==null) {
                rootElement = geo;
                continue;
            }
            for (TItem geo1 : elements) { //dziecko
                if (geo1.getId()==geo.getParentId()) {
                    geo1.getChildren().add(geo);
                    geo.setParent(geo1);
                }
            }
        }
    }

    public TItem getRootElement(){
        return rootElement;
    }


}
