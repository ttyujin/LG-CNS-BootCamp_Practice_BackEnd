import features.oop.sub.ManagerDTO;
import features.oop.sub.StudentDTO;
import features.oop.sub.TeacherDTO;
import features.oop.sup.PersonDTO;

public class OopApp {
    
    public static void main(String[] args) {
        
        // StudentDTO stu=new StudentDTO();
        // stu.setSsn("2026");
        // stu.setAge(0);
        // stu.setAddress(null);

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
        PersonDTO manager= new ManagerDTO("탁유진",27,"경기도","교권보호국");
        //managet.getDept() 접근할 수 있는 방법?
        //casting이 참조 타입에 적요오딜 수 있음(다만, 상속관계를 전제로)
       // System.out.println(manager.getDept()); -> 에러
        System.out.println(manager.getName());
        System.out.println(manager.getAge());
        System.out.println(manager.getAddress());
        System.out.println(((ManagerDTO)manager).getDept());

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
    }
}
