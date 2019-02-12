public interface Interface2<A> extends Interface1 {                      //接口也支持继承，接口可以多继承，extends后可以有多个子接口，接口可以嵌套在类中<A>泛型接口
    abstract void init2(A name);                                        //abstract抽象方法，接口自动是public的

    void init1();                                                       //接口重写了函数

    int DEFAULT_GAE = 12;                                                //接口中的任何域都是自动的static和final的，static final使用大写风格
    String DEFAULT_NAME = "name";

}