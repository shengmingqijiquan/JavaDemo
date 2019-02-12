//static int var=10;                                                            //java禁止使用全局数据
//一个包可以包含多个类，类默认访问修饰符为包访问，每个文件只能有一个public类，类只能是包访问或public
public class Student implements Comparable<Student> {                            //implements继承接口关键字，Comparable<Student>类比较接口
    public static void main(String[] args) {
    }                                   //每个类中都可以有一个main函数，用于调试

    public Student() {                                                           //不接受任何参数的叫默认构造器，没定义构造器，编译器会自动创建
        this("student", 12);                                                     //通过this仅能调用一个构造器，必须将构造器调用置于起始处
        getname();                                                              //构造器会调用成员函数和数据，所有在初始化构造器前会初始化成员数据
        printf("基类无参构造器");
    }

    public Student(String name, int age) {                                        //有参构造器
        this.age = age;
        this.name = name;
        printf("基类有参构造器" + name);
    }

    public Student(String name, Character... args) {                               //可变参数列表args是一个参数数组，重载方法中应只有一个可变参数列表，编译器
        this.name = name;
        printf("基类变参构造器");                                                 //args[0]表示变参中的第一个参数
    }

    public void setname(String name) {
        this.name = name;
        printf("基类设置名称:" + name);
    } //this表示对当前对象的引用

    public String getname() {
        printf("基类获取名称" + name);
        return name;
    }             //使用public方法实现对private数据的控制，保证类内数据安全

    void setage(int age) {
        printf("基类设置名称" + age);
        this.age = age;
    }

    private int getage() {
        return age;
    }                                           //private属于final方法

    static long time = 10;                                                        //所有类型数据均可在定义时初始化，数据均有默认值，所有类的静态数据最先初始化
    private int age = 0;                                                          //private外部不可以访问
    String name = "student";                                                    //不加访问修饰符，默认为包访问

    public enum allsex {man, woman}                                               //枚举类型，等价于类内组合class allsex{man，woman}，枚举类型可以有构造函数，有几个枚举实例就调用几次构造函数

    class Sextype {                                                              //内部类，在内部类声明为static时为嵌套类，嵌套类不属于对象，而属于类名
        public void setsex(allsex sextype) {                                     //枚举类型，可作为变量，相当于const
            printf("设置内部类性别");
            switch (sextype) {                                                  //枚举类型用在switch中，用于限制参数的可选项
                case man:
                    sexstring = "boy";
                    break;
                case woman:
                    sexstring = "girl";
                    break;
                default:
                    break;
            }
        }

        public Student getStudent() {
            sexstring += name;                                                    //内部类，嵌套类可以任意访问外部类数据，无论嵌套多少层
            return Student.this;                                                //返回外部类引用，当内部类是static时，内部类不存在对外部类的引用
        }

        private String sexstring;
    }

    public static <T> void printf(T str)                                        //泛型方法，
    {
        System.out.println(str.toString());                                 //System.out.println打印输出
    }


    //重写equals虚函数，java中除了static和final都是虚函数，（private属于final方法）
    public final boolean equals(Student another) {                               //final标记的函数不能被派生类重写
        printf("比较了两个基类");
        if (this.age == another.age && this.name == another.name)
            return true;
        return false;
    }

    //垃圾回收器准备收回对象占用内存时执行，java虚拟机并未面临内存耗尽的情形不会浪费时间执行垃圾回收，（垃圾回收：停止-复制，标记-清扫）
    public void finalize() {
        printf("基类对象" + name + "内存被收回");
    }

    void dispose() {
        printf("基类对象" + name + "清理函数");
    }

    @Override
    public int compareTo(Student arg0) {                                         //要实现排序，必须要实现的比较接口
        return age < arg0.age ? -1 : (age == arg0.age ? 0 : 1);                             //返回-1表示小于，0不表示等于，1表示大于
    }

}

//一个文件可以包含多个类，但是文件名必须和public类名相同，否则只能使用默认的包访问权限
abstract class Teacher {                                                         //abstract关键字表示为抽象类
    abstract void setname();                                                    //abstract抽象方法

    public String getname() {
        return name;
    }                                       //使用public方法实现对private数据的控制，保证类内数据安全

    String name = "teacher";                                                      //不加修饰符默认为报访问
}