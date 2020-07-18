package com.blackmagic.ssm.dao;

import com.blackmagic.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(int id)  throws Exception;
}
