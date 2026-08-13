import features.blogs.domain.dto.BlogRequestDTO;
import features.blogs.domain.dto.BlogResponseDTO;
import features.blogs.service.BlogService;

public class AryApp {
    /*
    - array는 꾸러미이다.
    - 참조타입
    - 단일데이터 타입만 담는다.
    - 고정길이(실행시점에 re-sizing X)
    - 첨자번지에 대한 관리(0~)
    - length 속성
    - []
    */
    public static void main(String[] args) {
        int [] ary=new int [10];
        ary[0]=10;
        ary[1]='A'; //단일데이터를 담아야되는데 문자는 아스키코드로 나타낼 수 있어서 A는 가능

        System.out.println(ary[0]);
        for(int idx=0; idx<ary.length; idx++){
            System.out.println(ary[idx]);
        }
        System.out.println();
        System.out.println("debug>>>>enhanced loop~");
        for(int data:ary){
            System.out.println(data);
        }
        ////////////////////////////////////////////////////////////
        /// Q) frontend로 부터 글 목록 요청이 들어왔다면?
        
        BlogResponseDTO [] blogsAry=new BlogResponseDTO[10];
        
        //builder 방식의 객체 생성
        BlogResponseDTO response= BlogResponseDTO    .builder()    
                                                     .status(200)
                                                     .message("good")
                                                     .build();
        blogsAry[0]=response;
        blogsAry[1]=response;
        blogsAry[2]=response;

        for(int idx=0; idx<blogsAry.length; idx++){
            BlogResponseDTO data=blogsAry[idx];
            if(data==null){
                break;
            }
            System.out.println(data.getMessage());
        }
        
        for(BlogResponseDTO data:blogsAry){
            if(data==null){
                break;
            }
            System.out.println(data.getMessage());
        }
        

        /////////////////////////////////////////////////////////////
        
        BlogResponseDTO[] resultAry=BlogService.builder().build().blogs();

        System.out.println(">>>>> main end");


    }
}
