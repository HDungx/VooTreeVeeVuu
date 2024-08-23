package com.VooTreeVeeVuu.usecase.RoleUseCases.CreateRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateRoleImpl}.
 */
@Generated
public class CreateRoleImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateRoleImpl apply(RegisteredBean registeredBean, CreateRoleImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
