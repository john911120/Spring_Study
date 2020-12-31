package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//(94-95)
	@Select("select sysdate from dual")
	public String getTime();// 인터페이스에서는 추상메소드
	
	// (99)
	@Select("select sysdate from dual")
	public String getTime2();
}
