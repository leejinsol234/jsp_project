package models.member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

public class JoinService {
    private Validator validator;
    private MemberDao memberDao;

    public JoinService(Validator validator,MemberDao memberDao){ //전략 패턴(확장에 열려 있는 구조)
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void join(Member member){ //의존 관계(메서드 안에서 변화에 유연하게 대응할 수 있도록 한다.->캡슐화)
        validator.check(member);

        memberDao.register(member); //검증 성공 시 가입 처리
    }

    public void join(HttpServletRequest request){
        String _agree = Objects.requireNonNullElse(request.getParameter("agree"),"false");
        boolean agree = _agree.equals("true") ? true : false;
        Member member=  Member.builder()
                .userId(request.getParameter("userId"))
                .userPw(request.getParameter("userPw"))
                .confirmUserPw(request.getParameter("confirmUserPw"))
                .email(request.getParameter("email"))
                .userNm(request.getParameter("userNm"))
                .agree(agree)
                .build();
        join(member);
    }
}
