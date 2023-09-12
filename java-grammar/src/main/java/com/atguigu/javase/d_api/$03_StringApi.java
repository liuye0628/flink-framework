package com.atguigu.javase.d_api;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;



//字符串的常用方法
public class $03_StringApi {


  /*
  需求一:将用户输入的所有单词转换为小写,如果用户没有输入单词,重新输入
    遇到的问题:Idea中单元测试里面,控制台输入不了
    解决方案:
        ①工具类中help --Edit Constom VM Options…
        ②打开配置,添加-Deditable.java.test.console=true
        ③重启IDEA
   */
    @Test
    public void myToLowerCase() throws IOException {
        boolean flag = true;
        while(flag){
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            System.out.print("请输入单词:");
            String input = br.readLine();
            if(input.length()>0&&input!=null){
                flag = false;
            }
            //*****String toLowerCase():将字符串转换为小写*****
            System.out.println("小写后的单词:"+input.toLowerCase());
        }
        //String input = br.readLine();

    }

    /*
    需求二:随机生成验证码,验证码由0-9,A-Z,a-z的字符组成
     */
    @Test
    public void generateCode() throws IOException {
        char[] chars = new char[26 * 2 + 10];
        for (int i = 0; i < 10; i++) {
            chars[i]=(char)('0'+i);
            //System.out.print(chars[i]+"\t");
        }
        //System.out.println();
        for(int i = 0,j = 10;j<10+26;i++,j++){
            chars[j]=(char)('A'+i);
            //System.out.print(chars[j]+"\t");
        }
        //System.out.println();
        for(int i = 0,j=36;j<36+26;i++,j++){
            chars[j]=(char)('a'+i);
            //System.out.print(chars[j]+"\t");
        }
        Random random = new Random();
        //System.out.println(random.nextInt(66));
        String result  = "";
        for(int i = 0;i<4;i++){
            result += chars[random.nextInt(chars.length)];
        }
        System.out.println("随机生成的验证码为:"+result);
        while(true){
            System.out.println("请输入验证码:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if(!line.toLowerCase().equals(result.toLowerCase())){
                System.out.println("验证码输入不正确");
            }else{
                System.out.println("验证码输入正确");
                break;
            }

        }
    }
    /**
     * 需求三:查找相关
     */
    @Test
    public void myFind(){
        String str = "阴阳师是一款网易出品的二次元手游,讲述了晴明失忆后和它的式神一起在平安京冒险收服其他式神的故事";
        //str是否包含"二次元"
        boolean a = str.contains("二次元");// boolean contains(xx):是否包含xx
        System.out.println(a);
        //"str"中"式神"第一次出现的下标
        int b = str.indexOf("式神");//int indexOf(xx):从前往后找当前字符串xx,如果有,返回第一次出现的下标,要是没有,返回-1
        System.out.println(b);
        //"str"中"式神"最后一次出现的下标
        int c = str.lastIndexOf("式神");//int lastIndexOf(xx):从后往前找当前字符串xx,如果有,返回第一次出现的下标,要是没有,返回-1
        System.out.println(c);


    }
    /**
     * 需求四:字符串截取
     */
    @Test
    public void mySubString(){
        String str = "helloworldhadoophivesparkflink";
        System.out.println(str.substring(5));//String subString(int beginIndex):返回一个新的字符串,它是从此字符串的beginIndex开始截取到最后一个的字符串
        System.out.println(str.substring(5,10));//String substringz(int beginIndex,int endIndex):返回一个新的字符串,它是此字符串从beginIndex开始截取到endIndex(不包含)的一个字符串
    }
    /**
     * 需求五:获取文件 文件名和后缀名
     */
    @Test
    public void myTest(){
        String fileName = "笑傲江湖.txt";
        System.out.println("文件名:"+fileName.substring(0,fileName.lastIndexOf(".")));
        System.out.println("后缀名:"+fileName.substring(fileName.lastIndexOf(".")));
    }
    /**
     * 需求六:和字符相关
     */
    @Test
    public void myCharacter(){
        //①将字符串中的字符按照大小顺序排列
        String str = "helloworld";
        char[] chars = str.toCharArray();// char[] toCharArray():将字符串转换为新的字符数组返回
        Arrays.sort(chars);
        System.out.println(str.charAt(5));// char charAt(int index):返回index位置的字符
        System.out.println(new String(chars));// String(char[] value):返回指定数组中表示该字符序列的String
        System.out.println(new String(chars,1,3));// String(char[] value,int offset, int count):返回指定数组中表示该字符序列的String
        System.out.println(String.copyValueOf(chars));//static String copyValueOf(char[] value)://返回指定数组中表示该字符序列的String
        System.out.println(String.copyValueOf(chars,1,3));//static String copyValueOf(char[] value,int offset,int count)://返回指定数组中表示该字符序列的String
        System.out.println(String.valueOf(chars));//static String valueOf(char[] value):返回指定数组中表示该字符序列的String
        System.out.println(String.valueOf(chars,1,3));//static String valueOf(char[] value,int offset,int count):返回指定数组中表示该字符序列的String

    }
    /**
     * 需求七:开头与结尾
     */
    @Test
    public void myStartAndEnd(){
        String fileName = "HelloWorld.java";
        System.out.println(fileName.startsWith("H"));//boolean startsWith(xx):是否以xx开头
        System.out.println(fileName.endsWith("a"));//boolean endsWith(xx):是否以xx结尾

    }

    /**
     * 需求八:编码与解码
     */
    @Test
    public void myUnicode() throws UnsupportedEncodingException {
        String str ="中国";
        //byte[] getBytes("字符编码方式"):按照指定的编码方式进行编码
        System.out.println(str.getBytes("GBK").length);//每个中文对应两个字节
        System.out.println(str.getBytes("UTF-8").length);//每个中文对应三个字节
        //new String(byte[],字符编码方式):解码,按照指定的编码方式进行解码
        String result = new String(str.getBytes("GBK"), "GBK");
        System.out.println(result);

    }

    /**
     * 需求九:正则
     *  常用正则表达式:
     *  ①字符类
     *          [abc] ： a 、 b 或 c （简单类）
     *          [^abc] ：任何字符，除了 a 、 b 或 c （否定）
     *          [a-zA-Z] ： a 到 z 或 A 到 Z ，两头的字母包括在内（范围）
     *  ②预定义字符类
     *          . ：任何字符（与行结束符可能匹配也可能不匹配）
     *          \d ：数字： [0-9]
     *          \D ：非数字： [^0-9]
     *          \s ：空白字符： [ \t\n\x0B\f\r]
     *          \S ：非空白字符： [^\s]
     *          \w ：单词字符： [a-zA-Z_0-9]
     *          \W ：非单词字符： [^\w]
     *  ③POSIX 字符类（仅 US-ASCII）
     *          \p{Lower} 小写字母字符：[a-z]
     *          \p{Upper} 大写字母字符：[A-Z]
     *          \p{ASCII} 所有 ASCII：[\x00-\x7F]
     *          \p{Alpha} 字母字符：[\p{Lower}\p{Upper}]
     *          \p{Digit} 十进制数字：[0-9]
     *          \p{Alnum} 字母数字字符：[\p{Alpha}\p{Digit}]
     *          \p{Punct} 标点符号：!"#$%&'()*+,-./:;<=>?@[]^_`{|}~
     *          \p{Blank} 空格或制表符：[ \t]
     *  ④边界匹配器
     *          ^ ：行的开头
     *          $ ：行的结尾
     *  ⑤Greedy 数量词
     *          X ? ：X，一次或一次也没有
     *          X * ：X，零次或多次
     *          X + ：X，一次或多次
     *          X { n } ：X，恰好 n 次
     *          X { n ,} ：X，至少 n 次
     *          X { n , m } ：X，至少 n 次，但是不超过 m 次
     *  ⑥Logical 运算符
     *          XY：X 后跟 Y
     *          X | Y：X 或 Y
     *          ( X ) ：X，作为捕获组
     *  ⑦特殊构造（非捕获）
     *          (?:X) X，作为非捕获组
     *          (?=X) X，通过零宽度的正 lookahead
     *          (?!X) X，通过零宽度的负 lookahead
     *          (?<=X) X，通过零宽度的正 lookbehind
     *          (?<!X) X，通过零宽度的负 lookbehind
     *          (?>X) X，作为独立的非捕获组
     */
    @Test
    public void myRegular(){
        //boolean matchs(正则表达式):判断当前字符串是否匹配某个正则表达式
        String str = "12345678";
        System.out.println(str.matches("\\d+"));

    }

    /**
     * 需求十:替换与拆分
     */
    @Test
    public void myReplace(){
        //替换
        String str = "helloworld123";
        System.out.println(str.replace("world", "hadoop"));//String replace(xx,yy):替换,不支持正则
        System.out.println(str.replaceFirst("[^a-zA-Z]", ""));//String replaceFirst(正则,value):替换第一个匹配部分,支持正则
        System.out.println(str.replaceAll("[^a-zA-Z]", ""));//String replaceAll(正则,value):替换所有匹配部分,支持正则
        //拆分
        String str1 ="1hello2hadoop";
        String[] split = str1.split("\\d");//String[] split(正则):按照某种规则进行拆分
        String result ="";
        for (int i = 0; i < split.length; i++) {
            result += split[i];
        }

    }


}
