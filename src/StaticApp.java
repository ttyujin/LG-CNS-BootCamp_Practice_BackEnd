import features.stat.StaticDemo;

public class StaticApp {
    

    public static void main(String[] args) {
        
        StaticDemo demo=new StaticDemo();
        System.out.println(demo.message);
        demo.message="메세지 변경";
        System.out.println(demo.message);

        System.out.println(StaticDemo.staticMessage);

        System.out.println(StaticDemo.PI);
        //StaticDemo.PI=3.15; 상수는 수정이 불가능하다.

        demo.instanceMethod();
        StaticDemo.classMethod();

    }
}
