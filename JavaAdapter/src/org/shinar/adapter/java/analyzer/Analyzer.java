package org.shinar.adapter.java.analyzer;

/**
 * Created by marco on 20/06/14.
 */
public interface Analyzer<TRepresentation>{
    public void obtainInformation();
    public TRepresentation getRepresentation();
    //public TResult analyze(TData data);
}
