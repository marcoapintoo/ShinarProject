package org.shinar;


import lombok.Data;

interface INothing<T extends Caller>{
    void call(T o);
}
class Caller implements ISubCaller0Visitor{
    //protected void calling(INothing<? extends Caller> handler){
    public void calling(ISubCaller0 handler){
        //((INothing<Caller>)handler).call(this);
        handler.call(this);
    }
    public void other(A<? extends Caller> target){
        //target.set(this);
    }
}
class SubCaller0 extends Caller{
    public void c(){
        System.out.println("Hola 0!!!");
    }
}class SubCaller1 extends SubCaller0{
    public void a(){
        System.out.println("Hola 1");
    }
    public void calling(ISubCaller0 handler){
        //((INothing<Caller>)handler).call(this);
        handler.call(this);
    }
}
interface ISubCaller1 extends INothing<SubCaller1>{}
interface ISubCaller2 extends INothing<SubCaller2>{}
interface ISubCaller0Visitor{
    void calling(ISubCaller0 handler);
}
interface ISubCaller0{
    void call(Caller o);
    void call(SubCaller0 o);
    void call(SubCaller1 o);
    void call(SubCaller2 o);
}
class SubCaller2 extends SubCaller0{
    public void b(){
        System.out.println("Hola 2");
    }
}
//class UltraCalling implements INothing<SubCaller0>{//ISubCaller1, ISubCaller2{
class UltraCalling implements ISubCaller0{//ISubCaller1, ISubCaller2{
    public void call(Caller c){
        System.out.println("!!!!!");
    }
    public void call(SubCaller0 c){
        c.c();
    }
    public void call(SubCaller1 c){
        c.a();
    }
    public void call(SubCaller2 c){
        c.b();

    }
}
interface A<T extends Caller>{
    void set(T o);
}
@Data
class ABC{
    int a;
public <T extends Caller> void set(T o){

}
}

public class Main {

    public static void main(String[] args) {
        /*new SubCaller1().calling(new UltraCalling());
        new SubCaller2().calling(new UltraCalling());
        new SubCaller0().calling(new UltraCalling());
        JavaAdapter adapter = new JavaAdapter();
        NimrodFormatter formatter = new NimrodFormatter();
        //String result = formatter.format(adapter.parseFile("Tests", "Example01.java"));
        String result = NimrodFactory.codeOf(adapter.parseFile("Tests", "Example01.java"));

        System.out.println(result);*/
        ABC a = new ABC();

    }
}
