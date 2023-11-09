package com.atguigu.javase.h_java8newfeature;

/**
 * 自定义函数式接口
 */

public interface $03_Calculator {
    /*
    public abstract 返回值类型 方法名称(可选参数信息)
    其他非抽象方法内容
    接口当中抽象方法的public abstract是可以省略的
     */
    int calc(int a, int b);
}
class Test{
    public static void invokeCalc(int a,int b,$03_Calculator calculator){
        int result = calculator.calc(a, b);
        System.out.println("结果是:"+result);
    }

    public static void main(String[] args) {
        invokeCalc(1,2,(int a, int b)->{return a + b;});
    }
}

/**
 * 消费型接口特点: 有形参,但是返回值类型是void
 * 接口名 抽象方法 描述
 * Consumer void accept(T t) 接收一个对象用于完成功能
 * BiConsumer<T,U> void accept(T t, U u) 接收两个对象用于完成功能
 * DoubleConsumer void accept(double value) 接收一个double值
 * IntConsumer void accept(int value) 接收一个int值
 * LongConsumer void accept(long value) 接收一个long值
 * ObjDoubleConsumer void accept(T t, double value) 接收一个对象和一个double值
 * ObjIntConsumer void accept(T t, int value) 接收一个对象和一个int值
 * ObjLongConsumer void accept(T t, long value) 接收一个对象和一个long值
 */

/**
 * 供给型接口特点:无参,但是无返回值
 * 接口名 抽象方法 描述
 * Supplier T get() 返回一个对象
 * BooleanSupplier boolean getAsBoolean() 返回一个boolean值
 * DoubleSupplier double getAsDouble() 返回一个double值
 * IntSupplier int getAsInt() 返回一个int值
 * LongSupplier long getAsLong() 返回一个long值
 */

/**
 * 判断型接口特点:有参,但是返回值类型是boolean结果
 * 接口名 抽象方法 描述
 * Predicate boolean test(T t) 接收一个对象
 * BiPredicate<T,U> boolean test(T t, U u) 接收两个对象
 * DoublePredicate boolean test(double value) 接收一个double值
 * IntPredicate boolean test(int value) 接收一个int值
 * LongPredicate boolean test(long value) 接收一个long值
 */

/**
 * 功能型接口特点:既有参数又有返回值
 * 接口名 抽象方法 描述
 * Function<T,R> R apply(T t) 接收一个T类型对象，返回一个R类型对象结果
 * UnaryOperator T apply(T t) 接收一个T类型对象，返回一个T类型对象结果
 * DoubleFunction R apply(double value) 接收一个double值，返回一个R类型对象
 * IntFunction R apply(int value) 接收一个int值，返回一个R类型对象
 * LongFunction R apply(long value) 接收一个long值，返回一个R类型对象
 * ToDoubleFunction double applyAsDouble(T value) 接收一个T类型对象，返回一个double
 * ToIntFunction int applyAsInt(T value) 接收一个T类型对象，返回一个int
 * ToLongFunction long applyAsLong(T value) 接收一个T类型对象，返回一个long
 * DoubleToIntFunction int applyAsInt(double value) 接收一个double值，返回一个int结果
 * DoubleToLongFunction long applyAsLong(double value) 接收一个double值，返回一个long结果
 * IntToDoubleFunction double applyAsDouble(int value) 接收一个int值，返回一个double结果
 * IntToLongFunction long applyAsLong(int value) 接收一个int值，返回一个long结果
 * LongToDoubleFunction double applyAsDouble(long value) 接收一个long值，返回一个double结果
 * LongToIntFunction int applyAsInt(long value) 接收一个long值，返回一个int结果
 * DoubleUnaryOperator double applyAsDouble(double operand) 接收一个double值，返回一个double
 * IntUnaryOperator int applyAsInt(int operand) 接收一个int值，返回一个int结果
 * LongUnaryOperator long applyAsLong(long operand) 接收一个long值，返回一个long结果
 * BiFunction<T,U,R> R apply(T t, U u) 接收一个T类型和一个U类型对象，返回一个R类型对象结果
 * BinaryOperator T apply(T t, T u) 接收两个T类型对象，返回一个T类型对象结果
 * ToDoubleBiFunction<T,U> double applyAsDouble(T t,U u) 接收一个T类型和一个U类型对象，返回一个double
 * ToIntBiFunction<T,U> int applyAsInt(T t, U u) 接收一个T类型和一个U类型对象，返回一个int
 * ToLongBiFunction<T,U> long applyAsLong(T t, U u) 接收一个T类型和一个U类型对象，返回一个long
 * DoubleBinaryOperator double applyAsDouble(double left, double right) 接收两个double值，返回一个double结果
 * IntBinaryOperator int applyAsInt(int left, int right) 接收两个int值，返回一个int结果
 * LongBinaryOperator long applyAsLong(long left, long right) 接收两个long值，返回一个long结果
 */