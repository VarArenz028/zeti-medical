package org.zeti.medical.json.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class JSONFilter
{
    public <T> MappingJacksonValue filterList(String filterName, Set<String> fields, List<T> list)
    {
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterName", propertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    public MappingJacksonValue filter(String filterName, Set<String> fields, Object object)
    {
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName, propertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
