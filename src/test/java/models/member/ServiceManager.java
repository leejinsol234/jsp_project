package models.member;

public class ServiceManager {

    //싱글톤 패턴
    private static ServiceManager instance;

    private ServiceManager(){}

    public static ServiceManager getInstance(){
        if(instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }

    public MemberDao memberDao(){
        return new MemberDao();
    }

    public JoinValidator joinValidator(){
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());
        return validator;
    }

    public JoinService joinService(){ //두 객체를 조립하는 기능
        return new JoinService(joinValidator(),memberDao());
    }


}
