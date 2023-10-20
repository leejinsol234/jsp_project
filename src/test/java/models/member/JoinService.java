package models.member;

import commons.BadRequestException;
import commons.Validator;

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
}
