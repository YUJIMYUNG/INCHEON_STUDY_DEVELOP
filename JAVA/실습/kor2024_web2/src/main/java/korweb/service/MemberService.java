package korweb.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import korweb.model.dto.MemberDto;
import korweb.model.dto.PointDto;
import korweb.model.entity.MemberEntity;
import korweb.model.entity.PointEntity;
import korweb.model.repository.MemberRepository;
import korweb.model.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FileService fileService;

    // [1]. 회원가입 서비스
    @Transactional // 트랜잭션
    public boolean signup( MemberDto memberDto ){
        // 프로필 사진 첨부파일이 존재하면 업로드 진행
        // (1) 만약에 업로드 파일이 비어있으면 dto에 'default.jpg'로 임시 프로필사진을 등록한다.
        if(memberDto.getUploadfile().isEmpty()){
            memberDto.setMimg("default.jpg");
        } else { // (2) 업로드 파일이 존재하면
            // 파일 서비스 객체 내 업로드 함수를 호출한다.
            String fileName = fileService.fileUpload(memberDto.getUploadfile()); // 업로드 함수에 multipart 객체를 호출한다.

            // (3) 만약에 업로드 반환된 값이 null 이면 업로드 실패, null이 아니면 업로드 성공
            if(fileName == null ){
                return false; // 업로드에 실패하면 회원가입도 실패
            } else {
                memberDto.setMimg(fileName); // 업로드 성공한 uuid+파일명을 dto에 대입한다.
            } // if-else end
        }


        // 1.  저장할 dto를 entity 로 변환한다.
        MemberEntity memberEntity = memberDto.toMemberEntity();
        // 2. 변환된 entity를 save한다.
        // 3. save(영속성/연결된) 한 엔티티를 반환 받는다.
        MemberEntity saveEntity = memberRepository.save( memberEntity );
        // 4. 만약에 영속된 엔티티의 회원번호가 0보다 크면 회원가입 성공
        if( saveEntity.getMno() > 0 ){
            PointDto pointDto = PointDto.builder()
                    .pcontent("회원가입축하")
                    .pcount( 100 )
                    .build();
            pointPayment( pointDto , memberEntity );
            return true;
        }
        else{ return  false;}
    } // f end

    // [2]. 로그인 서비스
    // security 사용시에는 아래 기능 사용하지 않음
//    @Transactional // 트랜잭션
////    public boolean login( MemberDto memberDto ){
////        //[방법1]
////        /*
////        // (1) 모든 회원 엔티티를 조회한다.
////        List<MemberEntity> memberEntityList = memberRepository.findAll();
////        // (2) 모든 회원 엔티티를 하나씩 조회한다.
////        for( int index = 0 ; index <= memberEntityList.size()-1 ; index++ ){
////            // (3) index번째의 엔티티를 꺼내기
////            MemberEntity memberEntity = memberEntityList.get(index);
////            // (4) index번째의 엔티티 아이디가 입력받은(dto) 아이디와 같으면
////            if( memberEntity.getMid().equals( memberDto.getMid() ) ) {
////                // (5) index번째의 엔티티 비밀번호가 입력받은(dto)비밀번호와 같으면
////                if( memberEntity.getMpwd().equals( memberDto.getMpwd() ) ){
////                    System.out.println(" login OK ");
////                    return true; // 로그인 성공
////                } // if end
////            } // if end
////        } // for end
////        return false; // 로그인 실패
////        */
////
////        // [방법2] JPA Repository 추상메소드 활용.
////        boolean result
////                = memberRepository.existsByMidAndMpwd( memberDto.getMid() , memberDto.getMpwd() );
////
////        if( result == true ){
////            System.out.println("로그인성공");
////            setSession( memberDto.getMid() ); // 로그인 성공시 세션에 아이디 저장
////            //  포인트 DTO 생성
////            PointDto pointDto = PointDto.builder()
////                    .pcontent("로그인접속")
////                    .pcount( 1 ).build();
////            // - 현재 로그인된 엔티티 찾기  // .findById( pk번호 ) : 지정한 pk번호의 엔티티 조회
////            MemberEntity memberEntity = memberRepository.findById(  getMyInfo().getMno() ).get();
////            // 포인트 지급 함수
////            pointPayment( pointDto , memberEntity );
////
////            return true; // 로그인 성공
////        }else{
////            System.out.println("로그인실패");
////            return false; // 로그인 실패
////        }
////    } // f end

    // 2-1. 시큐리티를 이용한 로그인 서비스
        // 1). 해당 서비스 클래스명 뒤에 implements UserDetailsService 추상메서드 주입
        // 2). loadUserByUsername 메서드 재정의(override)
    @Override
    public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException {
        System.out.println("username = " + mid); // 로그인시 입력받은 mid
        System.out.println("MemberService.loadUserByUsername");

        // 3). mid를 이용하여 데이터베이스에 저장된 암호화 패스워드를 가져오기
            //- 입력받은 아이디로 회원 엔티티 찾기
        MemberEntity memberEntity = memberRepository.findByMid(mid);
        if( memberEntity == null) { // 입력받은 아이디의 엔티티가 없으면
            throw new UsernameNotFoundException("없는 아이디 입니다.");
            //  throw : 던지다 new UsernameNotFoundException : 예외클래스 강제 실행
        } // if end

        // - 입력받은 아이디의 엔티티가 존재하면 암호화된 패스워드 확인
        String password = memberEntity.getMpwd();
        System.out.println("password" + password);

        // 4). 입력받은 mid와 입력받은 mid의 암호화된 패스워드를 리턴(리턴타입은 <UserDetails>)
            // UserDetails : 인터페이스명, 시큐리이에서 사용하는 유저 정보를 조작하는 인터페이스
            // User : 클래스, UserDetails를 구현하는 구현(객)체
            // --> 시큐리티는 UserDetails를 반환하면 자동으로 로그인 처리르 해준다.
            // 단! 입력받은 id와 입력받은 id의 암호화된 패스워드를 대입해줘야 한다.
        UserDetails user = User.builder().username(mid).password(password).build();

        // 5). UserDetails를 반환
        return user;
    }

    // ===================== 세션 관련 함수 ============== //
    // (1) 내장된 톰캣 서버의 요청 객체
    @Autowired private HttpServletRequest request;

    // [3] 세션객체내 정보 추가 : 세션객체에 로그인된 회원아이디를 추가하는 함수. ( 로그인 )
    // 시큐리티 이후에는 사용하지 않음 시큐리티에서 자동으로 세션 추가해줌
    public boolean setSession( String mid ){
        // (2) 요청 객체를 이용한 톰캣내 세션 객체를 반환한다.
        HttpSession httpSession = request.getSession();
        // (3) 세션 객체에 속성(새로운 값) 추가한다.
        httpSession.setAttribute( "loginId" , mid );
        return true;
    } // f end

    // [4] 세션객체내 정보 반환 : 세션객체에 로그인된 회원아이디 반환하는 함수 ( 내정보 조회 , 수정 등등 )
    // 시큐리티 이후에 커스텀 / 코드 수정
    public String getSession() {
        // 1). 시큐리티에서 자동으로 생성한 세션 꺼내기
            // SecurityContextHolder : 시큐리티에 관련된 정보 저장소
            // .getContext() : 저장소 반환
            // .getAuthentication() : 저장소에서 인증서 반환
            // . getPrincipal() : 주요한 인증 정보
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 2). 만약에 비로그인 이면
        if(object.equals("anonymousUser")) {
            return null; // 비로그인 상태이면 null 반환
        } // if end

        // 3). 로그인 상태이면 로그인 구현할때 'loginByUsername' 메소드 반환한 userDetails로 타입 변환
        UserDetails userDetails = (UserDetails) object;

        // 4). 로그인된 정보에서 mid를 꺼낸다.
        String loginMid = userDetails.getUsername(); // Username == mid

        // 5). 로그인 mid 반환
        return loginMid;
    }
//    public String getSession( ){
//        // (2)
//        HttpSession httpSession = request.getSession();
//        // (4) 세션 객체에 속성명의 값 반환한다. * 반환타입이 Object 이다.
//        Object object = httpSession.getAttribute( "loginId");
//        // (5) 검사후 타입변환
//        if( object != null ){// 만약에 세션 정보가 존재하면
//            String mid = (String)object; // Object타입 --> String타입
//            return mid;
//        }
//        return null;
//    } // f end

    // [5] 세션객체내 정보 초기화 : 로그아웃
    // security 사용시에는 아래 기능 사용하지 않음
    public boolean deleteSession(){
        HttpSession httpSession = request.getSession(); // (2)
        // (3) 세션객체 안에 특정한 속성명 제거
        httpSession.removeAttribute( "loginId");
        return true;
    }

    // [6] 현재 로그인된 회원의 회원정보 조회
    public MemberDto getMyInfo(){
        String mid = getSession();  // 1. 현재 세션에 저장된 회원 아이디 조회
        if( mid != null ){   // 2. 만약에 로그인상태이면
            MemberEntity memberEntity = memberRepository.findByMid( mid );  // 3. 회원아이디로 엔티티 조회
            MemberDto memberDto = memberEntity.toMemberDto(); // 4. entity --> dto 변환
            return memberDto;// 5. 반환
        }
        return null; // * 비로그인상태이면
    } // f end
    // [7] 현재 로그인된 회원 탈퇴
    public boolean myDelete( ){
        String mid = getSession(); // 1. 현재 세션에 저장된 회원 아이디 조회
        if( mid != null ){// 2. 만약에 로그인상태이면
            MemberEntity memberEntity = memberRepository.findByMid( mid ); // 3. 현재 로그인된 아이디로 엔티티 조회


            // 외래 키로 참조하고 있는 엔티티의 관계를 끊음
            List<PointEntity> relatedEntities = pointRepository.findByMemberEntity(memberEntity);
            for (PointEntity relatedEntity : relatedEntities) {
                relatedEntity.setMemberEntity(null);
            }

            memberRepository.delete( memberEntity ); // 4. 엔티티 탈퇴/삭제 하기
            deleteSession();// ** 로그인정보 지우기 : 로그아웃
            return true;// 5. 반환
        }
        return false; // * 비로그인상태이면
    } // f end

    // [8] 현재 로그인된 회원 정보 수정 , mname 닉네임 , memail 이메일
    @Transactional
    public boolean myUpdate( MemberDto memberDto ){
        String mid = getSession();
        if( mid != null ){
            MemberEntity memberEntity = memberRepository.findByMid( mid );
            memberEntity.setMname( memberDto.getMname() );
            memberEntity.setMemail( memberDto.getMemail() );
            return true;
        }
        return false;
    } // f end

    @Autowired private PointRepository pointRepository;

    // [9] (부가서비스) 포인트 지급 함수 . 지급내용 pcontent / 지급수량 pcount , 지급받는회원엔티티
    @Transactional
    public boolean pointPayment( PointDto pointDto , MemberEntity memberEntity ){

        PointEntity pointEntity = pointDto.toPointEntity();
        pointEntity.setMemberEntity( memberEntity ); // 지급받는 회원엔티티 대입

        PointEntity saveEntity = pointRepository.save( pointEntity  );
        if( saveEntity.getPno() > 0 ){return true; }
        else{ return false; }
    } // f end

    // [10] 내 포인트 지급 전제 내역 조회
    public List<PointDto> pointList(){
        // 1. (로그인된) 내정보 가져오기
        String mid = getSession();
        MemberEntity memberEntity = memberRepository.findByMid( mid );
        // 2. 내 포인트 조회하기
        List<PointEntity> pointEntityList = pointRepository.findByMemberEntity( memberEntity );
        // 3. 조회된 포인트 엔티티를 dto로 변환
        List<PointDto> pointDtoList = new ArrayList<>();
        pointEntityList.forEach( (entity) ->{
            pointDtoList.add( entity.toPointDto() );
        });
        return  pointDtoList;
    }

    // [11] 현재 내 포인트 조회
    public int pointInfo(){
        // 1. (로그인된) 내정보 가져오기
        String mid = getSession();
        MemberEntity memberEntity = memberRepository.findByMid( mid );
        // 2. 내 포인트 조회하기
        List<PointEntity> pointEntityList = pointRepository.findByMemberEntity( memberEntity );
        // 3. 조회된 포인트 엔티티의 합계 구하기.
        int myPoint = 0;
        for( int index = 0 ; index<=pointEntityList.size()-1 ; index++ ){
            myPoint += pointEntityList.get(index).getPcount();
        }
        return  myPoint;
    }


}
