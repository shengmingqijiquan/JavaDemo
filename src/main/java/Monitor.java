import java.util.EnumSet;

final class Monitor<T> extends Student implements Interface1,Interface2<String>{    //<>泛型，extends继承类，implements继承接口，final终态类，不能再被继承
    Monitor(){                                                                      //派生类无参构造器
        super("monitor");printf("派生类无参构造器");                                //关键字super显示调用基类构造器，printf调用基类函数
    }                                                                               //构造前会调用父类无参构造函数，如果父类没有构造函数，则会默认生成。如果有构造函数（无参），则会调用无参构造函数。如果只有有参构造函数，必须显示调用
    Monitor(int age){printf("派生类有参构造器");}                                   //派生类有参构造器，
    static Student mysStudent = new Student("monitor",12);                          //静态数据初始化只在调用时刻才会进行，在第一次创建类对象或者第一次访问静态数据时最先被初始化
    final static Student student1;                                                  //final用于，保持引用不变，对象可变
    static Student student2;
    static{                                                                         //静态块，仅执行一次，对象创建或静态数据访问时执行，仅定义对象的话不执行
        student1 = new Student();
        student2 = new Student();
        printf("派生类静态块执行");
    }
    //重写函数的返回类型可以是基类型的派生类型，访问权限必须大于原访问权限，子类抛出异常小于等于父类方法抛出异常
    public String getname(){                                                        //重写虚函数不需要关键字，因为在java中除了static和final都是虚函数（private属于final方法）
        printf("派生类获取名称:"+name);                                                //
        //name = super.name+"的派生";                                                  //super代表基类
        return name;
    }
    public int getage(){return 11;}                                                 //private不能重写，派生类重名，覆盖了基类私有方法


    String name="monitor";                                                              //同名变量和静态函数，不能动态绑定到基类引用上，和基类数据存储在不同的区域
    String task ="帮助老师管理班级";

    private T a;                                                                    //设置泛型，也可以使用原始基类Object
    public T getT(){return a;}                                                      //设置泛型函数，泛型会自动擦除传递过来的对象的类信息
    public void setT(T a){this.a=a;printf("派生类设置泛型变量");}

    public enum Group{                                                              //枚举类型，函数枚举
        SHUXUE{void action(){printf("数学");}},
        YINGYU{void action(){printf("英语");}},
        YUNWEN{void action(){printf("语文");}};
        abstract void action();                                                     //每个枚举元素要实现的函数
    }

    EnumSet<Group> allgroup=EnumSet.of(Group.SHUXUE,Group.YINGYU);                  //EnumSet枚举集合，EnumMap枚举映射
    public void printfgroup(){
        for(Group g:allgroup)
            g.action();
    }


    @Override
    public void init2(String name) {                                                //泛型接口
        printf("派生类实现接口2初始化函数");
    }
    @Override
    public void init1() {
        printf("派生类实现接口1初始化函数，或接口2初始化函数");
    }

}