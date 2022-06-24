package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext : DI container 라고 생각하면된다. 모든 DI는 ApplicationContext 로 부터 시작
        // AppConfig.class 에 있는 모든 bean을 주입
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 첫번째 파라미터에는 메서드 이름 두번째는 type
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(2L, "memberB", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(2L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
