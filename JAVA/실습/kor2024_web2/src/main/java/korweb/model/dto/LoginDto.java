package korweb.model.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

// 시큐리티의 일반회원가 oauth2회원 정보를 통합하는 DTO
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements UserDetails, OAuth2User {
    // UserDetails : 시큐리티의 일반 회원들의 정보를 조작하는 인터페이스
    // Oauth2User : 시큐리티에서 Oauth2회원들의 정보를 조작하는 인터페이스
    // 위 두 인터페이스를 LoginDto에서 구현 -> LoginDto에서 두 인터페이스를 모두 포함하므로 LoginDto 타입으로 두 타입을 조작할 수 있다.

    // + 필수
    private String mid; // 로그인한 회원의 아이디
    private String mpwd; // 로그인할 회원의 비밀번호(oauth2 회원은 사용하지 않음)
    private List<GrantedAuthority> mrolList; // 로그인한 회원의 권한/등급 목록

    // 추상클래스의 메서드 재정의

    // 계정의 만료 여부(기본값-true 만료되지않음)
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    // 계정 잠금 여부를 확인하는 메서드(기본값 true - 잠금이 아님, false-잠금)
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    // 비밀번호 만료 여부 확인하는 메서드 (기본값 true)
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    // 계정 활성화 여부 : 기본값(true)
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    // (재정의) 권한 목록을 반환하는 메서드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.mrolList;
    }

    // (재정의함)일반 회원이 로그인 비밀번호를 반환하는 메서드
    @Override
    public String getPassword() {
        return this.mpwd;
    }

    // (재정의함)일반 회원이 로그인 아이디를 반환하는 메서드
    // Username : 시큐리티에서는 로그인할 때 사용하는 Id 를 Username으로 씀
    @Override
    public String getUsername() {
        return this.mid;
    }

    // oauth2 회원에서 사용하는 oauth2 속성 객체 반환하는 메서드
    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    // oauth2 회원에서 사용하는 oauth2 속성 객체 반환하는 메서드
    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    // (재정의함)로그인한 회원의 정보를 반환할 메서드
    @Override
    public String getName() {
        return this.mid;
    }
}
