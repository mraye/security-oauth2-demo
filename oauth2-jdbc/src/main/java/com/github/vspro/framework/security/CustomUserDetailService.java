package com.github.vspro.framework.security;

import com.github.vspro.persistent.dao.UserMapper;
import com.github.vspro.persistent.domain.UserDo;
import org.apache.commons.lang3.text.StrTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created  on 2018/8/28.
 */


@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDo userDo = userMapper.queryByUserName(username);
        if (userDo == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        Set<GrantedAuthority> authies = new HashSet<>();
        List<String> dbAuthies = userMapper.queryUserRoleByUserName(username);
        if (!dbAuthies.isEmpty() && dbAuthies.size() > 0){
            List<GrantedAuthority> temp = dbAuthies
                    .stream()
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            authies.addAll(temp);
        }
        return new User(username, userDo.getPassword(), authies);
    }
}
