package com.VooTreeVeeVuu.usecase.RoleUseCases.GetRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetRoleImpl}.
 */
@Generated
public class GetRoleImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetRoleImpl apply(RegisteredBean registeredBean, GetRoleImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
