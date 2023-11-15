package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class SimpleMethod implements IMethodFacade{
    private Method method;

    public SimpleMethod(Method method) {
        this.method = method;
    }

    public boolean isPublic(){
        return Modifier.isPublic(method.getModifiers());
        }
    public boolean paramsCountEquals(int n){
        if(method.getParameterCount()==n)
            return true;
        return false;
    }
    public boolean startsWith(String prefix){
        return method.getName().startsWith(prefix);
    }

    public boolean isVoid(){
        return method.getReturnType().equals(Void.TYPE);
    }
    public boolean isSetter() {
        if (this.isPublic() && this.paramsCountEquals(1) && this.startsWith("set") && this.isVoid())
            return true;
        return false;
    }
    public boolean isGetter(){
        if (this.isPublic() && this.paramsCountEquals(0) && !this.isVoid() && this.startsWith("get") || this.startsWith("is"))
            return true;
        return false;}
    public String getFieldName(){
        return method.getName().toLowerCase().substring(3);
    }
    public Method GetUnderlyingMethod(){
        return this.method;}

}
