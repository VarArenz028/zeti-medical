package org.zeti.medical.jwt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.repository.UserAccountRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserAccountRepository userAccountRepository;

//        eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU0NTQ3MzU1MywiaWF0IjoxNTQ0ODY4NzUzfQ.LSU85ntL35DqpTtL-kGH5qGbYY_iGPcNICRCLc7rhg246PoQA2yulMttkMDxpaaZeYE2PoDNfqp6DtrLnH_zmQ

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserAccount userAccount = userAccountRepository.getUserAuthDetailsByUsername(username);
        JwtUserDetails jwtUserDetails = new JwtUserDetails(userAccount.getUserID(),
                                                           userAccount.getUsername(),
                                                           userAccount.getPassword(),
                                                           userAccount.getRole().trim());

        return jwtUserDetails;
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserAccount user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }

}
