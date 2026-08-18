package features.generics;

public class ResponseTemplate<T> {
    
    private int     code;
    private String  message;
    private T       data;


   public ResponseTemplate(){

   }


   public ResponseTemplate(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
   }


   public int getCode() {
    return code;
   }


   public String getMessage() {
    return message;
   }


   public T getData() {
    return data;
   }
   
}
