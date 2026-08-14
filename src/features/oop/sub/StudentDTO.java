package features.oop.sub;

import features.oop.sup.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter //데이터는 읽기전용이라서 getter만 받는 것이 이상적이다.
@ToString


public class StudentDTO extends PersonDTO { //personDTO 상속
    
    
    private String ssn; //ssn이라는 멤버 변수만 가지고 있음
    
    // public StudentDTO(){

    // }
    
    public StudentDTO(String name, int age, String address, String ssn) {
        super(name, age, address);
        this.ssn = ssn;
    }

    // public String getSsn() {
    //     return ssn;
    // }
    
    // public void setSsn(String ssn) {
    //     this.ssn = ssn;
    // }

    @Override
    public String personInfo() {
        return super.personInfo()+", ssn=" + ssn;
    }
}
