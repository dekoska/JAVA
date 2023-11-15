package org.example;

import java.lang.reflect.Method;

public interface IMethodFacade {
    public boolean isPublic();
    public boolean paramsCountEquals(int n);
    public boolean startsWith(String prefix);
    public boolean isVoid();
    public boolean isSetter();
    public boolean isGetter();
    public String getFieldName();
    public Method GetUnderlyingMethod();
}
