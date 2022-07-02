package com.liu.dongbao.ums;

import com.liu.dongbao.ums.entity.UmsMember;
import com.liu.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xiaok
 * @ClassName LiuDongBaoUmsApiApplicationTests
 * @date 2022/7/2 13:26
 * @description 测试插入操作
 */
@SpringBootTest
public class LiuDongBaoUmsApiApplicationTests {
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Test
    void insertUms() {
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("liujunchang");
        umsMember.setPassword("sss");
        umsMember.setEmail("sdf");
        umsMemberMapper.insert(umsMember);
        System.out.println(umsMember.getId());
    }

}
