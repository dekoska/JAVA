package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SimpleClass implements IClassFacade{
    private Class <?> clazz;

    public SimpleClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<IMethodFacade> getPublicDeclaredMethods(){
    return Stream.of(clazz.getDeclaredMethods())
            .map(m->(IMethodFacade)new SimpleMethod(m))
            .filter(m->m.isPublic())
            .toList();
    }
    public List<IMethodFacade> getPublicGetters(){
        return Stream.of(clazz.getDeclaredMethods())
                .map(m->(IMethodFacade)new SimpleMethod(m))
                .filter(m->m.isGetter())
                .toList();
    }
    public List<IMethodFacade> getPublicSetters(){
        return Stream.of(clazz.getDeclaredMethods())
                .map(m->(IMethodFacade)new SimpleMethod(m))
                .filter(m->m.isSetter())
                .toList();
    }
    public List<Field> getFieldsForPublicProperties(){return null;}






}
