package org.example.tools;

import org.example.tools.abstractions.IHaveHierarchicalStructure;

public class Hierarchy <TItem extends IHaveHierarchicalStructure<TItem>>{

    private TItem rootElement;

    public void setRootElement(TItem item){
        this.rootElement=item;
    }

    public TItem findElementById(int id){
        for(TItem children : rootElement.getChildren()){
            Hierarchy<TItem> hier = new Hierarchy<>();
            hier.setRootElement(children);
            children = hier.findElementById(id);
            if(id == children.getId())
            return children;
        }
        return rootElement;
    }


}
