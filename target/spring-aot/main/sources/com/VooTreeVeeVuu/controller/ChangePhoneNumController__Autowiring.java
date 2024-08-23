package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChangePhoneNumController}.
 */
@Generated
public class ChangePhoneNumController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChangePhoneNumController apply(RegisteredBean registeredBean,
      ChangePhoneNumController instance) {
    AutowiredFieldValueResolver.forRequiredField("accountService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
