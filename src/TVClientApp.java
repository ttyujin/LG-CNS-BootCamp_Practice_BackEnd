import features.oop.factory.BeanFactory;
import features.oop.tv.LgTV;
import features.oop.tv.SamsungTV;
import features.oop.tv.TV;

public class TVClientApp {
    
    public static void main(String[] args) {
        
        
        // SamsungTV tv=new SamsungTV();
        // tv.powerOn();

        // LgTV tv=new LgTV();
        // tv.turnOn();

        // TV tv=SamsungTV.getInstance();
        // System.out.println("debug>>>> tv address"+tv);
        BeanFactory factory=BeanFactory.getInstance();
        TV tv=factory.getBrand("samaung");
        TV tv1=factory.getBrand("lg");
        // System.out.println(tv+"\t"+tv1);
        tv.turnOn();
        
        // TV tv1=SamsungTV.getInstance();
        // System.out.println("debug>>>> tv address"+tv);
        // tv.turnOn();
    }
}
