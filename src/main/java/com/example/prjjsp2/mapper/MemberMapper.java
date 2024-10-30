package com.example.prjjsp2.mapper;

import com.example.prjjsp2.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {


    @Insert("""
                        INSERT INTO member
                        (id, password, nickName, description)
                        VALUES (#{id}, #{password}, #{nickName},#{description})
            """)
    void insert(Member member);


    @Select("""
            SELECT *
            FROM member
            ORDER BY id DESC
            """)
    List<Member> selectALL();


    @Select("""
            SELECT * FROM member
            WHERE id = #{id}
            """)
    Member selectById(String id);
}