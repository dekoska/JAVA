package org.example.tools.abstractions;

import org.example.Geography;

import java.util.List;

public interface IHaveHierarchicalStructure<TItem>{
    public void setParent(TItem geography);
    public List<TItem> getChildren();
    public TItem getParent();
    public int getId();
    public Integer getParentId();


}
