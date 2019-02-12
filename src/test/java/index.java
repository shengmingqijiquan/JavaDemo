import java.io.ByteArrayInputStream;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import javax.naming.InitialContext;

public class index implements Runnable {                                         //Runnable多线程，任务接口，如果类不是抽象类，必须实现接口函数，可以创建Thread的派生类，Callable<>有返回值的线程接口

    static String stringtemp;                                                   //类内共享变量

    public static void main(String[] args) {

        printf("===========基类相关操作==============");
        Preferences prefs = Preferences.userNodeForPackage(index.class);          //Preferences只能存放基本类型和字符串的键值对
        prefs.put("default_name", "student");                                   //Preferences用作属性配置
        prefs.putInt("default_age", 12);
        Student.time += Student.time << 2 + 0x21 ^ 26;                                  //静态数据，可以铜鼓类型访问，<<位左移动，低位补0，^按位异或，0X表示16进制
        Student student1 = new Student();                                         //所有的对象都必须通过new来创建，基本数据类型可以定义创建
        student1.name = student1.name + 1;                                        //访问类内数据，字符串+重载
        student1.setage(-2 * -6);                                                 //通过类内函数访问类数据，一元减号用于转变数据的符号
        Student.Sextype student1_sextype = student1.new Sextype();              //创建内部类，必须通过外部类变量new构造
        student1_sextype.setsex(Student.allsex.man);                            //调用枚举类型
        Student student2 = student1;                                              //仅是复制引用，两个变量名指向同一块内存
        if (student1 == student2)                                                  //==和!=只是比较对象的引用，不比较对象内容
            if (student1.equals(student2))                                       //对象的比较实用equals，比较对象的实际内容，但是定义类的equals默认行为还是比较引用，要在自定义类中重写equals函数
                //if(1)                                                         //非布尔值不能用在逻辑表达式中
                printf("创建了两个相同的类引用");

        Field[] fileds = student1.getClass().getDeclaredFields();               //反射获取对象类的属性
        try {                                                                    //尝试运行代码
            for (Field field : fileds) {
                if (!field.isAccessible())
                    field.setAccessible(true);                                  //设置对象属性可读取
                Object obj = field.get(student2);                             //从实例对象中获取字段属性的值，（私有的没法获取，数值或对象统一为对象，没有值返回的）
            }
        } catch (Exception e) {
            printf("错误内容：" + e.toString());                                   //catch函数在try出错时调用，exception是所有异常类的基类，异常类可以捕获派生类异常
            e.printStackTrace(System.out);                                      //堆轨迹，出错原因和位置
            //throw e;                                                          //抛出异常，停止运行
        } finally {                                                                //finally函数总要执行
            printf("finally函数总要执行");
        }

        printf("===========派生类相关操作==============");
        Monitor monitor1 = new Monitor(Interface2.DEFAULT_GAE);                      //基类构造函数（绑定后函数），派生类成员，派生类构造函数，接口中的域相当于枚举常量
        monitor1.name = "monitor1";                                                 //基类静态-派生类静态-基类私有-基类构造-派生类私有-派生类构造。函数在构造前已经存在
        printf("===========11111111111111111==============");
        sprintf(monitor1, null);                                                     //可变参数，null为参数为空
        sprintf(monitor1);                                                          //传递实现接口的类，向上转型为接口，实现函数回调
        printf("===========2222222222222222==============");
        Student student3 = new Monitor();                                       //基类引用，派生类对象
        student3.getname();                                                     //调用引用动态绑定的方法
        ((Monitor) student3).getage();                                           //向下转型成功，getage为派生类的公共函数

        printf("===========接口相关操作==============");
        Interface1 interface1 = new Monitor();                                    //向上转型，interface1是基类，普通类，接口，无所谓，实现接口的类（包括内部类），都可以向上转型转化为接口
        interface1.init1();                                                     //调用动态绑定的函数
        interface1 = getInterface1();                                             //通过匿名内部类实现接口函数的实现
        interface1.init1();

        printf("===========容器相关操作==============");
        //Collection接口，独立元素序列（List接口，Set接口，Queue接口）
        //List接口，插入顺序保存数组，（ArrayList数组，LinkedList链表）
        //Set接口，不能重复元素，（HashSet散列函数，TreeSet红黑树，LinkedHashList链表下的散列）
        //Queue接口，先进先出队列，（LinkedList链表，PriorityQueue优先级队列）

        //Map接口，键值对（字典，映射），HashMap（快速访问），TreeMap（键值排序），LinkedHashMap（保持元素插入顺序，通过散列提供快速访问）
        //list整体赋值,Arrays.asList方法返回的ArrayList是继承自AbstractList，不可变大小数组，作为参数生成可变大小的ArrayList
        List<String> allname = new ArrayList<String>(Arrays.asList("小明", "小红", "晓刚", "小刘"));  //ArrayList实现向上转型为list接口，动态连续数组，<>内的对象类型可以不写，不能是基本，<>内类型擦除，编译器无法获取，
        allname.set(2, "小刚");                                                    //list元素赋值
        if (!allname.contains("小王"))                                             //元素包含
            allname.add("小王");                                                  //添加元素
        allname.remove(0);                                                      //删除元素
        stringtemp = allname.get(1);                                              //读取元素
        Iterator<String> iterator = allname.iterator();                         //集合的迭代器，next为首个元素的迭代器，ListIterator迭代器更厉害
        iterator.next();                                                        //指向第一个元素
        iterator.remove();                                                      //删除迭代器的对应元素，删除可以继续使用此元素的迭代器了
        while (iterator.hasNext())                                               //迭代器是否有一下个元素
            printf(iterator.next());                                            //获取序列的下一个元素

        Stack<String> allname1 = new Stack<String>();                           //stack先进后出堆栈，各种队列和栈基于LinkedList链表实现
        LinkedList<String> allname2 = new LinkedList<String>();                 //双端队列，队列
        Set<String> allname3 = new HashSet<String>();                           //不重复集合
        Map<String, String> map = new HashMap<String, String>();                  //或者是SortedMap
        map.put("小明", "12");
        Object x_name = map.get("小明");
        Iterator iterator1 = map.entrySet().iterator();                         //Map对象有keySet方法，返回key的Set集合，values()返回Collection集合，entrySet函数返回集合，元素类型为Map.Entry（一个<key,vlaue>的泛型接口）
        Map.Entry entry = (Map.Entry) iterator1.next();
        Object key = entry.getKey();
        Iterator iterator2 = map.keySet().iterator();
        key = iterator2.next();
        x_name = map.get(key);
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            entry2.getKey();
            entry2.getValue();
        }
        List<Map.Entry<String, String>> info_student = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        printf("===========字符串相关操作==============");
        StringBuilder sb = new StringBuilder();                             //StringBuilder包括insert，replace，substring，reverse，append，tostring，delete方法
        sb.append(String.format("这里%s字符串相关操作", "shi"));             //string.format()格式化函数，内部创建formatter类设置字符串格式
        String outStr = sb.toString().replace("shi", "是");                    //string是不可变量，取值变化是生成新的类，replace替换，repalceAll，replaceFirst
        outStr = outStr.substring(3) + outStr.length();                         //substring取子字符串，length字符串长度，+重载连接字符串和整型
        if (outStr.indexOf("shi") < 0)                                         //indexof插叙子字符串所在位置，不存在返回-1，其他字符串相关操作较多
            printf("字符串\"" + outStr + "\"不存在指定子字符串");
        outStr = "luanpeng luanpeng";
        outStr = outStr.split(" ")[0];                                        //split分割字符串，返回数组，读取第一个数组赋值给outstr
        Pattern pattern = Pattern.compile("lu[a-n]");                       //创建正则法则，将正则字符串编译成正则表达式
        Matcher matcher = pattern.matcher(outStr);                          //创建匹配器
        while (matcher.find())                                              //依次查询是否存在匹配项
            printf(matcher.group() + "起点" + matcher.start() + "终点" + matcher.end());//group匹配值，start起始位置，end结束位置
        matcher.reset("luan");                                              //将正则法则重新使用到新的字符串上

        Integer nn = Integer.parseInt("123");                                //字符串转化为整型
        String str = String.valueOf(nn);                                    //整型转化为字符串
        char[] temparr = {'a', 'b'};                                          //字符数组
        str = new String(temparr);                                            //字符数组转化为字符串
        temparr = str.toCharArray();                                        //字符串转化为字符数组
        byte[] temp1 = str.getBytes();                                        //字符串转化为字节数组

        StringBuffer buf = new StringBuffer();                                //字符串的StringBuffer表示，
        buf.append(str + "\r\n");                                             //StringBuffer可以追加
        buf.deleteCharAt(buf.length() - 1);                                   //StringBuffer与StringBuilder有很多类似功能，这里不一一列举

        printf("===========数组相关操作==============");
        Random random = new Random(17);                                          //随机数
        int farrat[] = new int[10];                                              //数组创建int var[] 和int[] var等效
        for (int x : farrat) {                                                      //for语句的遍历形式
            x = random.nextInt();                                                 //读取伪随机序列
        }
        Student[] all1 = new Student[7];
        Student[] all2 = new Student[10];
        Arrays.fill(all1, student1);                                            //数组填充，填充对象时，只是填充了引用
        Arrays.fill(all2, student3);
        System.arraycopy(all1, 0, all2, 2, all1.length);                        //ii第0个开始复制到jj第2个开始，长度ii.length
        Arrays.sort(all2);                                                      //调用重写的比较函数执行数组排序
        int location = Arrays.binarySearch(all2, student1);                     //在数组中查找，不存在返回-1
        if (!Arrays.equals(all1, all2))                                          //数组相等   个数和每个元素均相等
            printf(Arrays.toString(all2));

        Monitor<Student> monitor2 = new Monitor<Student>();                         //包含泛型的类型调用，也可以不使用泛型创建对象
        monitor2.setT(student1);

        //注解
        //数据流
        //序列化
        printf("===========线程相关操作==============");
        new index().run();                                                      //在主线程中调用线程类中的run函数，不是多线程，只是调用函数
        Thread thread = new Thread(new index());                                  //调用子函数，执行线程类中run函数，thread构造参数为runnable接口，线程类向上转型为接口
        thread.setDaemon(true);                                                 //设置线程为后台线程，否则为非后台线程
        thread.start();                                                         //线程启动,thread.join()等待线程执行完毕
        thread.interrupt();                                                     //线程中断，会在线程运行至阻塞时中断，弹出中断异常
        ExecutorService exec = Executors.newCachedThreadPool();                  //创建线程池管理器
        exec.execute(new index());                                              //向线程管理器中添加一个线程实现接口，自动执行
        exec.submit(new index());                                               //调用有返回的线程
        exec.shutdown();                                                        //关闭线程管理器，线程池继续运行

        synchronized (stringtemp) {                                             //对象锁控制同步块，需要锁才能进入
            try {
                printf("进入同步块，释放对象锁");                                  //对象释放锁，进入等待锁定池，当接收到对象notify、notifyAll后进入对象锁定池，准备重新获取对象继续执行
                stringtemp.wait();                                              //wait，会抛出异常，synchronized 的目标与 wait() 方法的物件不相同，会有 IllegalMonitorStateException
                printf("同步控制块恢复继续执行");                                  //java里面有专门捕获异常的try catch。异常是向上依次抛出的，如果在某一层被捕获就不会退出。如果一直没有被捕获直到抛出到系统层就是退出。
            } catch (InterruptedException e) {                                  //中断异常类，会在线程运行至阻塞时中断，弹出中断异常
                e.printStackTrace();
            }
        }


        printf("结束");
        printf(Student.allsex.woman);
    }


    public static void sprintf(Student student, Object[] args)                   //基类参数允许传递派生类引用，//Object[] args用于可变参数列表，可以无参调用
    {
        student.setname("student1");                                            //调用引用动态绑定的方法-基类函数，修改的是基类属性
        student.getname();                                                      //调用引用动态绑定的方法-派生类重写的虚函数，获取的是派生类属性
    }

    public static void sprintf(Interface1 interface1)                           //接口参数允许传递接口类为参数，sprintf函数名相同实现重载
    {
        if (interface1 instanceof Monitor) {                                      //判断引用的类型是否是指定类型
            Student student = (Student) interface1;                                //先向下转型为monitor，在向上转型为student
            printf("接口类型：" + interface1.getClass().getName());                //获取引用指向的对象类型
            student.getname();                                                  //调用动态绑定的方法
        }
        interface1.init1();                                                     //接口相当于纯抽象类，调用动态绑定的方法   
    }


    public static Interface1 getInterface1() {                                  //不用创建实现接口的类，而直接实现接口的方法的定义
        return new Interface1() {                                                //匿名内部类，可以传递参数
            public void init1() {
                System.out.println("通过匿名内部类实现向上转型为接口");
            }
        };
    }


    public static synchronized <T> void printf(T str)                           //泛型方法，synchronized同步函数，检查锁，获取锁，执行代码，释放锁
    {
        System.out.println(str.toString());
    }

    int num = 0;

    @Override                                                                   //多线程，任务接口，只有调用线程接口才会执行
    public void run() {                                                          //线程接口重载函数
        Thread.currentThread().setPriority(++num);                              //设置线程优先级，优先级不会导致死锁，优先级低的执行频率低
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      //设置日期格式
        printf(df.format(new Date()) + "执行了线程" + num);                          // new Date()为获取当前系统时间
        Lock lock = new ReentrantLock();                                        //创建线程锁
        lock.lock();                                                            //锁定资源
        try {
            Thread.yield();                                                     //线程让步，不释放锁，yield不能设置时间，只能控制同优先级
            Thread.sleep(1000);                                                 //sleep可以使低优先级的线程得到执行的机会，线程睡眠，不释放锁，保持监控，自动恢复，sleep不操作锁，所以可以在非同步控制方法(块)中调用
        } catch (Exception e) {
            printf(df.format(new Date()) + "线程错误" + e.toString());
        } finally {
            lock.unlock();                                                      //释放锁
            printf(df.format(new Date()) + "释放锁");
            synchronized (stringtemp) {                                         //对象锁控制同步块，需要锁才能进入
                stringtemp.notifyAll();                                         //stringtemp调用线程恢复通知所有等待线程，wait、notify、notifyAll必须在同步控制方法(块)中调用                                             
            }
        }
    }
}