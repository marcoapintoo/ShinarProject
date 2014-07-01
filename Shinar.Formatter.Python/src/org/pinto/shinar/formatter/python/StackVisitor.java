package org.pinto.shinar.formatter.python;

import lombok.Value;
import org.pinto.shinar.language.core.visitor.IStackVisitorData;
import org.pinto.shinar.utils.IOutputWriter;

/**
 * Created by marco on 01/07/14.
 */
@Value
public class StackVisitor implements IStackVisitorData {
    private Object visitor;
    private Object data;
    private IOutputWriter outputWriter;
}
