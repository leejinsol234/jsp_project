package commons;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message); //정의하지 않으면 기본 생성자만 추가되므로
    }
}
