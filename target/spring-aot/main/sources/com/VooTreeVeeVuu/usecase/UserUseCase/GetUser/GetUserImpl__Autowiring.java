package com.VooTreeVeeVuu.usecase.UserUseCase.GetUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetUserImpl}.
 */
@Generated
public class GetUserImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetUserImpl apply(RegisteredBean registeredBean, GetUserImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
