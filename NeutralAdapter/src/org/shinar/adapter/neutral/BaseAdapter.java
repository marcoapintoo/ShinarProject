package org.shinar.adapter.neutral;


import lombok.Data;
import org.shinar.neutral.representation.CodeGroup;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Created by marco on 24/06/14.
 */
@Data
public abstract class BaseAdapter {
    public CodeGroup parseFile(String filename, String... subpaths) {
        try {
            return parseString(
                    new String(Files.readAllBytes(FileSystems.getDefault().getPath(filename, subpaths)))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract CodeGroup parseString(String code);
}
