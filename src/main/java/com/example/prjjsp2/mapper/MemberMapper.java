package com.example.prjjsp2.mapper;

import com.example.prjjsp2.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {


    @Insert("""
                        INSERT INTO member
                        (id, password, nick_name, description)
                        VALUES (#{id}, #{password}, #{nick_name},#{description})
            """)
    void insert(Member member);

}
