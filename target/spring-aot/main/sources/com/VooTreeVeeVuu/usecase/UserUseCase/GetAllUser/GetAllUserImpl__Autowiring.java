package com.VooTreeVeeVuu.usecase.UserUseCase.GetAllUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllUserImpl}.
 */
@Generated
public class GetAllUserImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllUserImpl apply(RegisteredBean registeredBean, GetAllUserImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
