package org.uno;

import org.eclipse.jdt.core.dom.ASTVisitor;

import java.io.Serializable;

interface AFoo {
    int constant = 12;
    public int value(int i);
    void value2(double d);
}

interface Foo {
}

abstract class X implements
        Foo,
        Foo2<String>,
        Serializable,
        Foo2<Foo2<Foo2<String>>> {
    //private int[] e;
    //private int[] e1={1,2,3,4};
    //private int[] e2=new int[]{1,2,3,4};
    public int ba1, ba2;
    public int ba = 1;

    public void deleteme() {
        if (1 % 2 == 0) {
            System.out.print("Never shown...");
        }else {
            ASTVisitor
            System.out.print("Always shown...");
        }
        int i = 0;
        i++;
        i = i * 10;
        if (i % 2 == 0) {
            System.out.print("Par!");
        } else {
            System.out.println(i + " ");
        }
    }

}

interface Foo2<T extends Object & Serializable> {
}

interface Foo3 extends Foo2<String>, Foo {
}

enum Example {
    Data1,
    Data2,
    Data3
}

protected class Y extends X {
}

interface Other {
    public String methodName();
}