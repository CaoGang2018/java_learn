import learn.cao.test;

import java.util.StringJoiner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world!");
        test t1 = new test(78);
        System.out.println(t1.getAge());
        t1.setAge(67);
        System.out.println(t1.getAge());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(i);
        }
        System.out.println(sb.toString());
        StringJoiner sj = new StringJoiner("-", "Hello ", " !");
        for(int i = 0; i <10; i++){
            sj.add(String.valueOf(i));
        }
        System.out.println(sj.toString());
    }
}
