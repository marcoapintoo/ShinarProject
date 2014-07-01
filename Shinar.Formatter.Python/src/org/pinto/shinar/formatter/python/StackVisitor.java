package org.pinto.shinar.formatter.python;

import lombok.Value;
import org.pinto.shinar.language.core.visitor.IStackVisitorData;

/**
 * Created by marco on 01/07/14.
 */
@Value
public class StackVisitor implements IStackVisitorData {
    private Object visitor;
    private Object data;
}
