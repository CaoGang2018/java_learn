package lambda;

/**
 * @author admin_cg
 * @date 2020/8/9 15:39
 */
public class Testcase {

    // 3 静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda1() {
            System.out.println("I like lambda2!");
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lambda1();


        like = new Like2();
        like.lambda1();


        //4 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda1() {
                System.out.println("I like lambda3!");
            }
        }
        like = new Like3();
        like.lambda1();

        //5 匿名内部类

        like = new ILike() {
            @Override
            public void lambda1() {
                System.out.println("I like lambda4!");
            }
        };
        like.lambda1();

        //6 lambda 简化
        like = () -> {
            System.out.println("I like lambda5!");
        };
        like.lambda1();

    }

}

// 1 定义一个函数式接口
interface ILike{
    void lambda1();
}

// 实现类
class Like implements ILike{
    @Override
    public void lambda1() {
        System.out.println("I like lambda!");
    }
}

