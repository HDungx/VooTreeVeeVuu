package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CustomOAuth2AuthenticationSuccessHandler}.
 */
@Generated
public class CustomOAuth2AuthenticationSuccessHandler__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CustomOAuth2AuthenticationSuccessHandler apply(RegisteredBean registeredBean,
      CustomOAuth2AuthenticationSuccessHandler instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
