package com.VooTreeVeeVuu.usecase.RoleUseCases.UpdateRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateRoleImpl}.
 */
@Generated
public class UpdateRoleImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateRoleImpl apply(RegisteredBean registeredBean, UpdateRoleImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
