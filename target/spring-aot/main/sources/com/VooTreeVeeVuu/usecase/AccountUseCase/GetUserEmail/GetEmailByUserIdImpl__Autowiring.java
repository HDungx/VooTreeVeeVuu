package com.VooTreeVeeVuu.usecase.AccountUseCase.GetUserEmail;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetEmailByUserIdImpl}.
 */
@Generated
public class GetEmailByUserIdImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetEmailByUserIdImpl apply(RegisteredBean registeredBean,
      GetEmailByUserIdImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accountRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
