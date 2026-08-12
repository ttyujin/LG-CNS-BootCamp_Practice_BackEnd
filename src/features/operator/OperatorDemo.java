package features.operator;

import features.blogs.domain.dto.BlogRequestDTO;
import features.blogs.domain.dto.BlogResponseDTO;

public class OperatorDemo {
    public OperatorDemo(){

    }
    //반환타입 x, 매개변수 x
    public void operator(){
        System.out.println(">>>>산술연산자:+,-,*,/,%,+=,-=,*=,/= etc...");
        System.out.println(">>>>증감연산자:++,--");
        System.out.println(">>>>삼항연산자:(조건식)?true:false");
        System.out.println(">>>>논리연산자:&,|,!,&&,||");
        System.out.println(">>>>관계연산자:>,>=,<,<=,==,!=");
    }

    public BlogResponseDTO register(String title,String content,String email){

        System.out.println(">>>> 반환타입 o, 매개변수 o");
        System.out.println(">>>> 전달된 매개변수를 가지고 업무로직을 처리");
        if (email == "tyusejin@gmail.com"){
            return new BlogResponseDTO(201,"OK");
        } else {
            return new BlogResponseDTO(400,"FAIL");

        }
    }

    public BlogResponseDTO register(BlogRequestDTO request){
        if (request.getEmail() == "tyusejin@gmail.com"){
            return new BlogResponseDTO(201,"OK");
        } else {
            return new BlogResponseDTO(400,"FAIL");

        }
    }

    /*Q)
    매개변수 number 값의 범위 : 1 ~ 3 
    - 1 : 금도끼, 2 : 은도끼, 3 : 쇠도끼
    - 나무꾼이 자기의 도끼가 1번이라고 하면 -> 산신령이 대답하길 "거짓말하는구나"
    - 나무꾼이 자기의 도끼가 2번이라고 하면 -> 산신령이 대답하길 "또 거짓말하는구나"
    - 나무꾼이 자기의 도끼가 3번이라고 하면 -> 산신령이 대답하길 "정직하구나 너에게 모든 도끼를 주겠다"
     */
    
    public String woodMan(int number) {
        // case 1
        // if (number >= 1 && number <= 3) {
        //     if (number == 1) {
        //         return "거짓말하는구나";
        //     } else if (number == 2) {
        //         return "또 거짓말하는구나";
        //     } else {
        //         return "정직하구나 다 주마";
        //     }
        // } else {
        //     return "예?";
        // }

        //case 2 -> 삼항연산자
        // public String ifWoodMan(int number) {
        // // 삼항연산자 중첩: 범위 밖 -> 1번 -> 2번 -> 나머지(3번) 순으로 걸러진다
        //     return (number < 1 || number > 3) ? "1~3 사이의 번호만 말할 수 있느니라"
        //             : (number == 1) ? "거짓말하는구나"
        //                     : (number == 2) ? "거짓말하는구나"
        //                             : "정직하구나. 너에게 모든 도끼를 주겠다";

        //case 3 -> switch 케이스
        // switch (number) {
        //     case 1:
        //         return "거짓말하는구나";
        //     case 2:
        //         return "또 거짓말하는구나";
        //     case 3:
        //         return "정직하구나 너에게 모든 도끼를 주겠다";
        //     default:
        //         return "1 ~ 3 사이의 숫자를 입력해주세요.";
        // }

        //case 4 -> lambda
        //case params type: byte, short, int, char, String, enum
        String result=null;
        switch(number){
            case 1  ->    result="산신령이 대답하길~ 거짓말 하는구나";
            case 2  ->    result="산신령이 대답하길~ 또 거짓말 하는구나";
            case 3  ->    result="산신령이 대답하길~ 정직하구나. 너에게 모든 도끼를 주겠다";
            default ->    result="1~3 사이의 숫자를 입력하세요.";
        }
        return result;

        
    }
    
    /*
    반복구문? (for,while,do~while)
    - [], Collection API(List,Set,Map) 
    - Stream API(foreach)-> 자바 버전 8버전 이후 ! lambda식을 알아야한다
    -함수형 인터페이스 (Supplier, Consumer, Function, Predicate)
    - 요소의 타입으로 기본 타입보다 참조타입을 활용하는 방법
    - continue, break: 반복 도중 종료, 계속 진행하기 위한 키워드
     */

        //하한값의 경계와 상한값의 경계를 포함하는 총합을 반환하고 싶다?
        public int sumNumber(int start, int end){
            
            int result=0;
            int temp=0;

            if(start>end){
                temp=start;
                start=end;
                end=temp;
            }
           
            for(int data=start; data <= end; data++){
            result+=data;
           }
            return result;
        }

        /*
        Q)
        ? static
        -1~100 사이의 난수를 발생시킬 얘정(어떻게?)
        -casting
        int nan=(int)(Math.random()*100)+1; 호출
        -1~ 해당 난수까지의 총 누적합을 계산

        !hint
        -static method
        -argument X,
        -return type:int
        -method name:sumRandom
        */

        public static int sumRandom() {

            int result = 0;
            int nan = (int)(Math.random() * 100) + 1;
            System.out.println("debug>>>>generate naa="+nan);

            //case 1 -> for문
            // for(int i = 1; i <= nan; i++) {
            //     result += i;
            // }

            //case 2 -> while 문
            // int data=1;
            // while(data<=nan){
            //     result+=data;
            //     data++;
            // }

            //case 3 -> do while
            int data=1;
            
            do{
                result+=data;
                data++;
            }while(data<=nan);
           
            return result;
        }

        /*
        format:%d, %s, %f
        System.out.printf()
        
        -argument:int,
        -return type:void
        -method name: printGugudan
        */

        public void printGugudan(int dan){
            for(int idx=1;idx<=9;idx++){
                System.out.printf("%d*%d=%d\t",dan,idx,(dan*idx));
            }
        }

        public void gugudan(){
            for(int row=2;row<=9;row++){
                // System.out.printf("row=%d\t",row);
                // System.out.println();
                for(int col=2;col<=9;col++){
                System.out.printf("%d*%d=%d\t",row,col,(row*col));
                }
                System.out.println();
                
            }
        }

        //5단까지만 구구단을 출력하고 싶다면?
        public void gugudan5(){
            for(int row=2;row<=9;row++){
                // System.out.printf("row=%d\t",row);
                // System.out.println();
                for(int col=2;col<=9;col++){
                System.out.printf("%d*%d=%d\t",row,col,(row*col));
                }
                System.out.println();
                
                if(row==5){
                    break;
                }
            }
        }

        //문자열도 반복구문 이용이 가능할까?

        public void popStr(String str){
            System.out.println("debug >> params:"+str);
            System.out.println("debug >> str length:"+str.length());
            for(int idx=str.length()-1;idx>=0;idx--){
                System.out.print(str.charAt(idx));
            }
            System.out.println();
        }

}
