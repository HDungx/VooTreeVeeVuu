package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AccountService}.
 */
@Generated
public class AccountService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AccountService apply(RegisteredBean registeredBean, AccountService instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("otpRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("passwordEncoder").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("emailService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("jwtUtils").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
