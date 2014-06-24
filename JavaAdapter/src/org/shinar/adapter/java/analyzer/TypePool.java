package org.shinar.adapter.java.analyzer;

import lombok.Data;
import org.shinar.neutral.representation.NeutralCodeUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class TypePool<T extends NeutralCodeUnit> extends HashMap<Object, T> {
    private TypePool() {
        super();
    }

    public T get(Object key, T defaultValue) {
        if (!containsKey(key)) {
            put(key, defaultValue);
        }
        return get(key);

    }

    public List<T> findByPackage(String packageName) {
        List<T> result = new ArrayList<T>();
        for (T type : this.values()) {
            if (type.getDirectory().getFullName().equals(packageName)) {
                result.add(type);
            }
        }
        return result;
    }

    public List<T> findByName(String name) {
        List<T> result = new ArrayList<T>();
        for (T type : this.values()) {
            if (type.getName().equals(name)) {
                result.add(type);
            }
        }
        return result;
    }

    public List<T> findByQualifiedName(String name) {
        List<T> result = new ArrayList<T>();
        for (T type : this.values()) {
            if (type.getQualifiedName().equals(name)) {
                result.add(type);
            }
        }
        return result;
    }

    private static String typeKey(NeutralCodeUnit unit) {
        return unit.getQualifiedName();
    }

    public static TypePool<NeutralCodeUnit> typePool = null;

    public synchronized static TypePool<NeutralCodeUnit> pool() {
        if (typePool == null) {
            typePool = new TypePool<NeutralCodeUnit>();
        }
        return typePool;
    }
}
