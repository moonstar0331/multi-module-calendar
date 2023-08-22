package com.moon.fc.project.api.service;

import com.moon.fc.project.api.dto.LoginReq;
import com.moon.fc.project.api.dto.SignUpReq;
import com.moon.fc.project.core.domain.entity.User;
import com.moon.fc.project.core.service.UserService;
import com.moon.fc.project.core.dto.UserCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    public final static String LOGIN_SESSION_KEY = "USER_ID";
    private final UserService userService;

    @Transactional
    public void signUp(SignUpReq signUpReq, HttpSession session) {
        /**
         * UserService 에 Create 을 담당. (이미 존재하는 경우의 유저 검증은 userService의 몫)
         * 생성이 되면 session 에 담고 리턴
         */
        final User user = userService.create(new UserCreateReq(
                signUpReq.getName(),
                signUpReq.getEmail(),
                signUpReq.getPassword(),
                signUpReq.getBirthday()
        ));
        session.setAttribute(LOGIN_SESSION_KEY, user.getId());
    }

    @Transactional
    public void login(LoginReq loginReq, HttpSession session) {
        /**
         * 세션 값이 있으면 리턴
         * 세션 값이 없ㅇ면 비밀번호 체크 후에 로그인 & 세션에 담고 리턴
         */
        final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
        if(userId != null) {
            return;
        }
        final Optional<User> user = userService.findPwMatchUser(loginReq.getEmail(), loginReq.getPassword());

        if(user.isPresent()) {
            session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
        } else {
            throw new RuntimeException("password or email not match");
        }
    }

    public void logout(HttpSession session) {
        /**
         * 세션 제거하고 끝
         */
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
