public interface Interface1 {                                                    //interface接口声明，完全抽象类
    abstract void init1();                                                      //abstract抽象方法，接口自动是public的，接口中，不能定义函数体，只能声明，abstract可以不写

    class manclass implements Interface1 {                                       //接口内部类自动是public和static的。属于嵌套类，接口内部类实现接口函数，为了创建接口所有不同实现的公共代码
        @Override
        public void init1() {
            System.out.println("接口内部类，实现公共代码");
        }

    }
}