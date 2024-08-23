package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmailSenderController}.
 */
@Generated
public class EmailSenderController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmailSenderController apply(RegisteredBean registeredBean,
      EmailSenderController instance) {
    AutowiredFieldValueResolver.forRequiredField("emailService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
