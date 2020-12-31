package org.zerock.mapper;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
	// (662)
	public MemberVO read(String userid);
}
