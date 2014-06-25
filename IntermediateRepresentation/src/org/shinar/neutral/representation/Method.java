package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.statement.CodeBlock;
import org.shinar.neutral.representation.statement.ListVariableDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class Method extends NeutralObject {
    private boolean constructor = false;
    private NeutralCodeUnit returnType;
    @Setter(AccessLevel.PROTECTED)
    private CodeBlock block = new CodeBlock();
    @Setter(AccessLevel.PROTECTED)
    private List<NeutralCodeUnit> typeParameters = new ArrayList<NeutralCodeUnit>();
    ListVariableDeclaration parameters = new ListVariableDeclaration();
}
