package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // MemberServiceImpl은 추상화(MemberRepository - interface) 그리고 구현체 (MemoryMemberRepository) 모두에 의존한다
    // 이것은 OCP, DIP 모두에 위배된다.

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
