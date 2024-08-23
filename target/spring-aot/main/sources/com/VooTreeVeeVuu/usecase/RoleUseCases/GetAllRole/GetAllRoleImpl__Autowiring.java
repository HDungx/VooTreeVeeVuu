package com.VooTreeVeeVuu.usecase.RoleUseCases.GetAllRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRoleImpl}.
 */
@Generated
public class GetAllRoleImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRoleImpl apply(RegisteredBean registeredBean, GetAllRoleImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
