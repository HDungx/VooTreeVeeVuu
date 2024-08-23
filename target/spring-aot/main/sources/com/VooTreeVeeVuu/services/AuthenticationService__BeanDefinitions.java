package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.RoleRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link AuthenticationService}.
 */
@Generated
public class AuthenticationService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authenticationService'.
   */
  private static BeanInstanceSupplier<AuthenticationService> getAuthenticationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationService>forConstructor(AccountRepository.class, PasswordEncoder.class, JwtUtils.class, AuthenticationManager.class, RoleRepository.class)
            .withGenerator((registeredBean, args) -> new AuthenticationService(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'authenticationService'.
   */
  public static BeanDefinition getAuthenticationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationService.class);
    beanDefinition.setInstanceSupplier(getAuthenticationServiceInstanceSupplier());
    return beanDefinition;
  }
}
