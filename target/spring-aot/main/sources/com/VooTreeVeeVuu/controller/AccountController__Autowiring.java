package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AccountController}.
 */
@Generated
public class AccountController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AccountController apply(RegisteredBean registeredBean, AccountController instance) {
    AutowiredFieldValueResolver.forRequiredField("getAllAccountsUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAccountUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateStatusUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("accountService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getEmailByUserId").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
