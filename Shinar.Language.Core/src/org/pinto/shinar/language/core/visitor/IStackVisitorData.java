package org.pinto.shinar.language.core.visitor;

/**
 * Created by marco on 01/07/14.
 */
public interface IStackVisitorData {
    <TVisitor> TVisitor getVisitor();

    <TData> TData getData();
}
