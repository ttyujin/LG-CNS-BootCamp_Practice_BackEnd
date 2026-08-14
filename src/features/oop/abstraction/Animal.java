package features.oop.abstraction;

public abstract class Animal { //추상클래스

    private String name;

    public Animal(){

    }

    public void eating(String food){
        System.out.println(food+"를 먹고 삽니다.");
    }

    // public abstract void fly();
    // public abstract void takeoff();
    // public abstract void landing();
}