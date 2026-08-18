import java.util.ArrayList;
import java.util.List;

import features.generics.ResponseTemplate;
import features.oop.sub.ManagerDTO;
import features.oop.sub.StudentDTO;
import features.oop.sub.TeacherDTO;
import features.oop.sup.PersonDTO;

public class GenericsApp {
    
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("debug>>>>generics app");

        // ResponseTemplate<Integer> errCode=new ResponseTemplate<>();
        // errCode.setCode(200);
        // System.out.println("code: "+errCode.getCode());

        // System.out.println();
        // ResponseTemplate<String> errMessage=new ResponseTemplate<>();
        // errMessage.setCode("리소스 생성완료");
        // System.out.println("message: "+errMessage.getCode());

        //generic wildcard: extends vs super
        //이는 매소드의 매개변수 타입 선언 및 리천 차입을 지정할 때 자주 사용을 한다.
        //extends: 읽기 전용(T의 하위 타입)
        //super: 쓰기 전용(T의 상위 타입)
        
        List<PersonDTO> personList=new ArrayList<PersonDTO>();
        //List<? extends PersonDTO> personList=new ArrayList<PersonDTO>();
        //List<? super PersonDTO> personList=new ArrayList<PersonDTO>();

        StudentDTO student = StudentDTO .builder()
                                        .name("inspire")
                                        .build();
        TeacherDTO teacher=TeacherDTO   .builder()
                                        .name("tyujin").build();
        ManagerDTO manager=ManagerDTO   .builder()
                                        .name("lgcns").build();
        
        personList.add(student);
        personList.add(teacher);
        personList.add(manager);

        //입력 성공: 201, CREATED, XXXDTO

        // ResponseTemplate<PersonDTO> response =
        //         new ResponseTemplate<PersonDTO>(201, "CREATED", student);
        
        //목록 조회: 200, OK, list
        ResponseTemplate<List<PersonDTO>> response =
                new ResponseTemplate<List<PersonDTO>>(201, "OK", personList);

        List<PersonDTO> lst=response.getData();

        for(int idx=0; idx<lst.size(); idx++){
            Object person=lst.get(idx);
            System.out.println(((PersonDTO)person).personInfo());
        }
    }
}
