import features.oop.service.OopService;
import features.oop.sub.ManagerDTO;
import features.oop.sub.StudentDTO;
import features.oop.sub.TeacherDTO;
import features.oop.sup.PersonDTO;
import features.oop.util.Flag;

public class OopApp {
    
    public static void main(String[] args) {
        
        // StudentDTO stu=new StudentDTO();  일반적인 객체생성 / this에 대한 접근
        // stu.setSsn("2026");
        // stu.setAge(0);
        // stu.setAddress(null); //super에 대한 접근

        StudentDTO stu= new StudentDTO("탁유진",27,"경기도","2026");
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getAddress());
        System.out.println(stu.getSsn());
        /////////////////////////////////
        
        TeacherDTO tea = new TeacherDTO("탁선생", 35, "서울", "Java");

        System.out.println(tea.getName());
        System.out.println(tea.getAge());
        System.out.println(tea.getAddress());
        System.out.println(tea.getSubject());

        /////////////////////////////////
        PersonDTO manager= new ManagerDTO("탁유진",27,"경기도","교권보호국"); //persondto이라는 객체가 managerdto객체에 접근
        //managet.getDept() 접근할 수 있는 방법?
        //casting이 참조 타입에 적요오딜 수 있음(다만, 상속관계를 전제로)
       // System.out.println(manager.getDept()); -> 에러
        System.out.println(manager.getName());
        System.out.println(manager.getAge());
        System.out.println(manager.getAddress());
        System.out.println(((ManagerDTO)manager).getDept()); //manager에 직접 접근이 안되서 (())이라는 casting 접근으로만 가능

        ////////////////////////////////
        
        PersonDTO[] ary =new PersonDTO[3];
        ary[0]=new TeacherDTO("탁유진",20,"서울","python");
        ary[1]=new ManagerDTO("나유성",20,"서울","교육팀");
        ary[2]=new StudentDTO("임찬혁",20,"서울","2026");

        PersonDTO per01=ary[0];
        System.out.println(per01.getName());
        System.out.println(per01.getAge());
        System.out.println(per01.getAddress());
        System.out.println(((TeacherDTO)per01).getSubject());

        // for (int idx=0; idx<ary.length; idx++){
        //     PersonDTO per=ary[idx];
        //     if(per instanceof TeacherDTO){
        //         System.out.println(((TeacherDTO)per).getSubject());
        //     }
        //     else if(per instanceof ManagerDTO){
        //         System.out.println(((ManagerDTO)per).getDept());
        //     }
        //     else{
        //         System.out.println(((StudentDTO)per).getSsn());
        //     }
        //    }

        for (int idx=0; idx<ary.length; idx++){
            PersonDTO per=ary[idx];
            System.out.println(per.personInfo());
    }

        System.out.println();
        System.out.println();
        System.out.println("debug>>>>매개변수의 다형성");


        OopService service=new OopService();
        
        // service.setAry(stu);
        // service.setAry(tea); 
        // service.setAry(manager); 매개변수의 다형성 적용

        //이름을 key로 활용
        service.makePerson(Flag.STUDENT, "탁유진", 27, "sanbon", "2026");
        service.makePerson(Flag.TEACHER, "나유성", 25, "seoul", "java");
        service.makePerson(Flag.MANAGER, "임찬혁", 25, "incheon", "교권보호국");

        System.out.println();
        System.out.println();
        System.out.println("debug>>>정보 출력");
       
        PersonDTO[] result=service.getAry();

        for(PersonDTO person:result){
            if(person==null){
                break;
            }
            System.out.println(person.personInfo()); //다형성 사용 왜? 2026, java, 교권 보호국이 출력이 되서
        }

        System.out.println();
        System.out.println();
        System.out.println("debug>>>findPersin");
        PersonDTO find=service.findPerson("탁유진");
        if(find!=null){
            System.out.println(find.personInfo());
        }else{
            System.out.println(">>>>Not Found!!");
        }
        

    }
}
