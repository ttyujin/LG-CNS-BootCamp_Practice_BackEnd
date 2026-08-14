//service라는 파일이 있으면 비즈니스 로직이 있다고 생각
package features.oop.service;
/*
-배열을 통한 xxxxDTO를 관리하고 싶다.
-search,delete,insert,update 요청처리
*/

import features.oop.sub.ManagerDTO;
import features.oop.sub.StudentDTO;
import features.oop.sub.TeacherDTO;
import features.oop.sup.PersonDTO;
import features.oop.util.Flag;

public class OopService {
    private PersonDTO[]     ary; //배열에 담을 수 있는 것은 PersinDTO이다.
    private int             idx;

    public OopService(){
        ary=new PersonDTO[10];
        idx=0;
    }
    //setAry는 오버로딩임
    // public void setAry(TeacherDTO tea){
    //     ary[idx++]=tea;
    // }
    // public void setAry(StudentDTO stu){
    //     ary[idx++]=stu;
    // }
    // public void setAry(ManagerDTO man){
    //     ary[idx++]=man;
    // }

    //매개변수의 다형성
    private void setAry(PersonDTO per){
        ary[idx++]=per;
    }
    //shallow copy와 deep copy에 대해 생각해보기
    //shallow copy: 원본과 같은 형식으로 복사 
    //deep copy: 독립된 하나의 복사본을 생성
    public PersonDTO[] getAry(){
        return ary;
    }

    /*crud에 대해 만들기
    CRUD
    -params : flag, name, age, address, comm(ssn, subject, dept) 
    이런거를 하나하나 다 선언하면 어려워져서 이는 DTO로 담고 builder로 해주는 것이 편하다.
    -flag : 1 -> Student, 2 -> Teacher, 3 -> Mananger
    -makePerson() 매개변수로 전달된 값을 가지고 타입에 맞는 객체를 생성하고 배열 담는 역할
    */

    public void makePerson(Flag flag, String name, int age, String address, String comm){
        System.out.println("debug>>>>enum flag: "+flag);
        System.out.println("debug>>>>enum flag: "+flag.getFlag());
        
        //case 1
        // switch (flag.getFlag()) {
        //     case 1 -> System.out.println("학생");
        //     case 2 -> System.out.println("강사");
        //     case 3 -> System.out.println("매니저");
                
        // }
        
        //case 2
        //  switch (flag) {
        //     case STUDENT->System.out.println("학생");
        //     case TEACHER->System.out.println("강사");
        //     case MANAGER->System.out.println("매니저");
                
        // }

        //case 3
        //삼항연산자 사용
        PersonDTO per = 
        (flag.getFlag() == 1) 
            ?
                StudentDTO.builder()
                    .name(name).age(age).address(address)
                    .ssn(comm).build()
            : (flag.getFlag() == 2) ?
                TeacherDTO.builder()
                    .name(name).age(age).address(address)
                    .subject(comm).build()
            :   ManagerDTO.builder()
                    .name(name).age(age).address(address)
                    .dept(comm).build() ;

        setAry(per);
    }

    /*
    params:name
    method:findPerson
    return:PersonDTO
    q)이름(이름은 key여서 중복되면 안된다)을 전달받아서 일치하는 이름을 가진 PersonDTO를 리턴한다. 하지만 못 찾더라도 PersonDTO 반환.
    */

    public PersonDTO findPerson(String name){
        PersonDTO result=null;

        for(PersonDTO person : ary){

            if(person == null){
                break;
            }
            else{
                if(person.getName().equals(name)){
                    return person;
                    // result= person;
                    // break;
                    }   
            }
        }

        return result;
    }

}
