package commons;

public interface RequiredValidator {
    default void requiredCheck(String str, RuntimeException e){
        if(str == null || str.isBlank()){
            throw e;
        }
    }

    default void requiredTrue(boolean result, RuntimeException e){
        if(!result){ //참이 아닐 때 예외 처리
            throw e;
        }
    }
}
