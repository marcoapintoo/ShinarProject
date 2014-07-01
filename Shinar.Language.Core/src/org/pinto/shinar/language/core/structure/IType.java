package org.pinto.shinar.language.core.structure;


/**
 * Created by marco on 28/06/14.
 */
public interface IType extends IWithFlags, IWithName, IWithContext {

    Iterable<IElement> getElements();

    boolean hasElements();

    ITypeReference getTypeReference(ITypeReference... genericArguments);

    <T> T visit(IStructureVisitor<T> visitor);
}
