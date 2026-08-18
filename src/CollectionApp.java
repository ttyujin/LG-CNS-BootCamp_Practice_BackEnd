import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.Set;

import features.oop.sub.ManagerDTO;
import features.oop.sub.StudentDTO;
import features.oop.sub.TeacherDTO;
import features.oop.sup.PersonDTO;

public class CollectionApp {

    /*
    Collection API(-java.util.*)
    실무에서는 배열보다는 Collection API를 사용한다. 이는 자료구조라고 보면 된다.
    - List (특징: 데이터의 중복허용, 순서 존재, 요소의 타입으로 객체를 담는다, 가변길이)
    - Set (특징: 중복허용 x, 순서존재 x, 요소의 타입으로 객체만, 가변길이)
    - Map ({key:value},{key:value},...) 이들은 다 inteface다. 즉, 객체 생성이 불가능하다. 

    Boxing, UnBoxing
    Wrapper Class(primitive type -> reference type, reference type <- primitive type)
    -int -> Integer
    -char -> Character

    Generics (파라미터 타입)
    T - type
    E - elements
    K - key
    V - value
    N - number

    */
     
    public static void main(String[] args) {

        System.out.println("debug >>>> array");

        int[] intAry = {1, 2, 3, 4, 5};

        System.out.println(intAry.length);
        System.out.println(Arrays.toString(intAry));

        System.out.println();
        System.out.println("debug>>>> Collection API - List");
        List<String> list = new ArrayList<String>();
        list.add("String");

        // generic 문법에 의한 error
        // list.add(10);
        // list.add(new Integer(10));
        // list.add(true);

        System.out.println("debug >>>> list " + list.size());
        System.out.println("debug >>>> list " + list);
        for(int idx=0; idx<list.size(); idx++){
            String data=list.get(idx);
            System.out.println(data);
        }

        System.out.println();
        System.out.println("debug>>>> ArrayList Element xxxxxDTO");
        List<PersonDTO> personList=new ArrayList<PersonDTO>();
        StudentDTO student=StudentDTO   .builder()
                                        .name("inspire").build();
        TeacherDTO teacher=TeacherDTO   .builder()
                                        .name("tyujin").build();
        ManagerDTO manager=ManagerDTO   .builder()
                                        .name("lgcns").build();

        personList.add(student);
        personList.add(teacher);
        personList.add(manager);
        
        //명령적 처리
        // List<String> filteringList=new ArrayList<String>();
        // for(int idx=0; idx<personList.size(); idx++){
        //     PersonDTO person=personList.get(idx);
        //     if(person.getName().startsWith("t")){
        //        filteringList.add(person.getName().toUpperCase());    
        //     }
        //     System.out.println(person.personInfo());
        // }

        //Stream API (선언적 처리)
        //컬렉션을 Steam 객체로 바인딩 하고 - 중간 연산(0~N)을 통해 연산 결과를 최종적(1)으로 연산
        //System.out::println을 함수 내부에 사용
        //s -> s.startWith()을 함수 내부에 사용
        List<String> filteringList = personList .stream()
                                                .filter( s -> s.getName().startsWith("t"))
                                                .map( s -> s.getName().toUpperCase() ) 
                                                .collect(Collectors.toList());
        System.out.println(filteringList);

        System.out.println("debug>>>> stream");
        personList  .stream()
                    .filter(person->person.getName().length()>5)
                    // .forEach((System.out::println));
                    .forEach(person->System.out.println(person.personInfo())); //lambda식 방법

        System.out.println();
        System.out.println("debug>>>>Set");
        Set<String> set=new HashSet<>();
        set.add("tyujin");
        set.add("inspire");
        set.add("lgcns");
        set.add("tyujin");
        System.out.println(set);
        Object [] setAry=set.toArray();
        for(Object data:setAry){
            System.out.println(data);
        }

        System.out.println();
        System.out.println("debug>>>>map(key:value)===Json");

        List<StudentDTO> studentList=new ArrayList<StudentDTO>();
        List<TeacherDTO> teacherList=new ArrayList<TeacherDTO>();
        List<ManagerDTO> managerList=new ArrayList<ManagerDTO>();
        Map<String,List<? extends PersonDTO>> map=new HashMap<>();
        map.put("student",studentList);
        map.put("teacher",teacherList);
        map.put("manager",managerList);

        // List<? extends PersonDTO> mapList=map.get("student");
        // List<? extends PersonDTO> mapList=map.get("manager");
        
        // List<? extends PersonDTO> mapList=map.get("teacher");
        // mapList.forEach(person->System.out.println(person.personInfo()));

        // map .get("student")
        //     .stream()
        //     .filter(null)
        //     .map(null)
        //     .forEach(person->System.out.println(person.personInfo()));


    }

         



        
}
