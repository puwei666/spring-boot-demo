package com.puwei666.demo.util;


import com.alibaba.fastjson.serializer.NameFilter;
import com.puwei666.demo.annotation.CamelName;

public class CamelNameSerializeFilter implements NameFilter {
    @Override
    public String process(Object object, String name, Object value) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        Class clazz = object.getClass();
        if (!clazz.isAnnotationPresent(CamelName.class)) {
            return name;
        }
        char[] nameArray = name.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : nameArray) {
            if (Character.isUpperCase(c)) {
                char lowerChar = Character.toLowerCase(c);
                sb.append('_').append(lowerChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
