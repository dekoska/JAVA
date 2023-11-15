package org.example.tools.abstractions;

import org.example.Geography;

public interface IParse<TResult>{
    public Geography parse(String line);
}
