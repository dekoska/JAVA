package org.example.tools.geographies;

import org.example.Geography;
import org.example.tools.abstractions.IParse;

public class GeographyParser implements IParse<Geography> {

    public Geography parse(String line){
        String[] data = line.trim().split(";");
        Geography geo = new Geography();
        geo.setId(Integer.parseInt(data[0]));
        geo.setType(data[1]);
        geo.setName(data[2]);
        geo.setCode(data[3]);
            if(!data[4].equals("NULL")){
                geo.setParentId(Integer.parseInt(data[4]));
        }
        return geo;

    }





}
