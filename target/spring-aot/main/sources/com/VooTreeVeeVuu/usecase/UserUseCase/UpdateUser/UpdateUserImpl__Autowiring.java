package com.VooTreeVeeVuu.usecase.UserUseCase.UpdateUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateUserImpl}.
 */
@Generated
public class UpdateUserImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateUserImpl apply(RegisteredBean registeredBean, UpdateUserImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
