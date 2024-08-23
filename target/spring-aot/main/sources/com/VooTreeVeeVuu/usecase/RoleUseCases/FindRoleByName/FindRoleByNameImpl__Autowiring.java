package com.VooTreeVeeVuu.usecase.RoleUseCases.FindRoleByName;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link FindRoleByNameImpl}.
 */
@Generated
public class FindRoleByNameImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static FindRoleByNameImpl apply(RegisteredBean registeredBean,
      FindRoleByNameImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roleRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
