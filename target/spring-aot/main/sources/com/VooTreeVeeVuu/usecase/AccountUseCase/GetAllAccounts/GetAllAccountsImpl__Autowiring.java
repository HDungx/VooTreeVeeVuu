package com.VooTreeVeeVuu.usecase.AccountUseCase.GetAllAccounts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllAccountsImpl}.
 */
@Generated
public class GetAllAccountsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllAccountsImpl apply(RegisteredBean registeredBean,
      GetAllAccountsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
