package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	@Setter(onMethod_= @Autowired)
	private MemberMapper memberMapper;
	
	// (670) CustomUserDetailsService에서 CustomUser를 반환하도록 수정
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load user by userName : " + username);
		// userName means userid
		MemberVO vo = memberMapper.read(username);
		log.warn("queried by member mapper : " + vo);
				
		return vo == null ? null : new CustomUser(vo);
	}
	
}
