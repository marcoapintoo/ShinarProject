package org.shinar.neutral.representation;

import lombok.Data;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class Directory {
    private String name = "";
    private Directory parent = null;

    public String getFullName() {
        return parent != null ? parent.getFullName() + "." + name : name;
    }

    public static Directory of(String fullName) {
        String[] names = fullName.split("\\.");
        Directory last = null, current = null;
        for (String name : names) {
            current = new Directory();
            current.setName(name);
            current.setParent(last);
            last = current;
        }
        return current;
    }
}
