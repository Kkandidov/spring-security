package org.astashonok.springsecurity.security;

import lombok.RequiredArgsConstructor;
import org.astashonok.springsecurity.model.User;
import org.astashonok.springsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(UserDetailsServiceImpl.NAME)
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  public static final String NAME = "userDetailsServiceImpl";

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email).orElseThrow(() ->
        new UsernameNotFoundException("User doesn't exist"));

    return SecurityUser.fromUser(user);
  }
}
