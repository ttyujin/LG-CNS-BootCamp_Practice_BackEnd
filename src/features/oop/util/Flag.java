package features.oop.util;

/*
enum: 특수 클래스로 정해져있는 상수의 집합
*/

public enum Flag {

  STUDENT(1),TEACHER(2),MANAGER(3);
  
  private final int flag;

  private Flag(int flag){
    this.flag=flag;
  }
  public int getFlag(){
    return this.flag;
  }
}
