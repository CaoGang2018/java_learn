package lambda;

/**
 * @author admin_cg
 * @date 2020/8/9 15:59
 */
public class Testlambda2 {
    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("I love you -> " + a);
        };

        love.love(6);
        love = a -> {
            System.out.println("I love you -> " + a);
        };
    }
}


interface ILove{
    void love(int a);
}

