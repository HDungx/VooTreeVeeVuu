package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChangeEmailController}.
 */
@Generated
public class ChangeEmailController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChangeEmailController apply(RegisteredBean registeredBean,
      ChangeEmailController instance) {
    AutowiredFieldValueResolver.forRequiredField("accountService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
