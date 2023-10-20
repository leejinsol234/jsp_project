package models.member;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member){
        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12)); //유동 해시 BCrypt로 암호화
        member.setUserPw(userPw);
        members.put(member.getUserId(),member);
    }

    public Member get(String userId){
        return members.get(userId);
    }

    public boolean exists(String userId){
        return members.containsKey(userId);
    }

    public static void clearData(){ //DB 연동시 필요 없음.
        members.clear();
    }
}
