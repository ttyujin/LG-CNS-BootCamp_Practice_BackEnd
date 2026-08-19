import features.oop.factory.BeanFactory;
import features.oop.tv.LgTV;
import features.oop.tv.SamsungTV;
import features.oop.tv.TV;

public class TvClientApp {

    public static void main(String[] args) {

        BeanFactory factory = BeanFactory.getInstance() ;
        
        TV tv = factory.getBrand("lg");
        tv.turnOn();     

    }

}
