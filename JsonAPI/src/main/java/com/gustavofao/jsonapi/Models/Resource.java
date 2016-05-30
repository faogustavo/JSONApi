package com.gustavofao.jsonapi.Models;

import com.gustavofao.jsonapi.Annotations.Excluded;
import com.gustavofao.jsonapi.Annotations.Id;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Annotations.Types;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resource {

    @Id
    private String id;
    private Links links;

    @Excluded
    private String type;

    @Excluded
    protected boolean hasAttributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        if (getClass().getAnnotation(Type.class) != null)
            return getClass().getAnnotation(Type.class).value();
        if (type == null && getClass().getAnnotation(Types.class).value() != null && getClass().getAnnotation(Types.class).value().length > 0)
            return getClass().getAnnotation(Types.class).value()[0];
        return type;
    }

    public boolean hasAttributes() {
        return hasAttributes;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != getClass())
            return false;

        List<Field> fields = getFields(getClass());
        for (Field f : fields) {
            boolean acessible = f.isAccessible();
            try {
                f.setAccessible(true);
                if (!f.get(this).equals(f.get(o)))
                    return false;
            } catch (Exception e) {

            }finally {
                f.setAccessible(acessible);
            }
        }

        return true;
    }

    private static List<Field> getFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null && !type.getSuperclass().getName().equals(Object.class.getName())) {
            fields.addAll(getFields(type.getSuperclass()));
        }

        return fields;
    }
}
