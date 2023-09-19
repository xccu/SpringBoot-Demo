package com.example.springdata.demo;

import com.example.springdata.demo.audit.MyAuditorAware;
import com.example.springdata.demo.model.AuditUser;
import com.example.springdata.demo.model.User;
import com.example.springdata.demo.repository.AuditUserRepository;
import com.example.springdata.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DataJpaTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Import(JpaConfiguration.class)
class AuditTests {

    @Autowired
    private AuditUserRepository auditUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private MyAuditorAware myAuditorAware;

    @Test
    void testAuditing() {
        // 我们这⾥利⽤ @MockBean，mock 掉我们的⽅法，期待返回 13 这个⽤户 ID
        //Mockito.when(myAuditorAware.getCurrentAuditor())
        //        .thenReturn(Optional.of(13));

        // 我们没有显式的指定更新时间、创建时间、更新⼈、创建⼈
        AuditUser  user = AuditUser.builder()
                .age(10)
                .name("test")
                .password("123")
                .sex("male")
                .race("Unknown")

                .build();
        auditUserRepository.save(user);
        // 验证是否有创建时间、更新时间，UserID是否正确；
        List<AuditUser> users = auditUserRepository.findAll();
        //Assertions.assertEquals(13, users.get(0).getId());
        //Assertions.assertNotNull(users.get(0).getUpdateTime());
        System.out.println(users.get(0));

        /*Optional<User> userOptional =  userRepository.findById(3);
        User user = userOptional.get();
        System.out.println(user);*/
    }

}
