package com.VooTreeVeeVuu.usecase.AccountUseCase.UpdateAccount;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateStatusImpl}.
 */
@Generated
public class UpdateStatusImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateStatusImpl apply(RegisteredBean registeredBean, UpdateStatusImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
