package commons;

public interface Validator<T> { //검증할 대상이 여러 개이므로 제네릭 클래스 사용
    void check(T t);
}
