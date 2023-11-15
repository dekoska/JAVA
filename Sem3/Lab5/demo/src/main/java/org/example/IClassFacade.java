package org.example;

import java.lang.reflect.Field;
import java.util.List;

public interface IClassFacade {
    public List<IMethodFacade> getPublicDeclaredMethods();
    public List<IMethodFacade> getPublicGetters();
    public List<IMethodFacade> getPublicSetters();
    public List<Field> getFieldsForPublicProperties();

}
