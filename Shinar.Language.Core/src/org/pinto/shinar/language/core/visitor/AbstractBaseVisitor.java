package org.pinto.shinar.language.core.visitor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Stack;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class AbstractBaseVisitor {
    @Setter(AccessLevel.NONE)
    private Stack<Object> stack = new Stack<Object>();
}
