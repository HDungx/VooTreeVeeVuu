package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ResetPasswordController}.
 */
@Generated
public class ResetPasswordController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ResetPasswordController apply(RegisteredBean registeredBean,
      ResetPasswordController instance) {
    AutowiredFieldValueResolver.forRequiredField("accountService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
