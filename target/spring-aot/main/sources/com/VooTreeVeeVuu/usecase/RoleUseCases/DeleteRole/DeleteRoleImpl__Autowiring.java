package com.VooTreeVeeVuu.usecase.RoleUseCases.DeleteRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteRoleImpl}.
 */
@Generated
public class DeleteRoleImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteRoleImpl apply(RegisteredBean registeredBean, DeleteRoleImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
