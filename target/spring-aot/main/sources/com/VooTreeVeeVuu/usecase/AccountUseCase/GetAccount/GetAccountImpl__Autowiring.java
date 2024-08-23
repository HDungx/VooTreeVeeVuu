package com.VooTreeVeeVuu.usecase.AccountUseCase.GetAccount;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAccountImpl}.
 */
@Generated
public class GetAccountImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAccountImpl apply(RegisteredBean registeredBean, GetAccountImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
