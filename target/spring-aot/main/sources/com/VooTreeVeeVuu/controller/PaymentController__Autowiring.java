package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PaymentController}.
 */
@Generated
public class PaymentController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PaymentController apply(RegisteredBean registeredBean, PaymentController instance) {
    AutowiredFieldValueResolver.forRequiredField("paymentService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
