package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoleController}.
 */
@Generated
public class RoleController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoleController apply(RegisteredBean registeredBean, RoleController instance) {
    AutowiredFieldValueResolver.forRequiredField("getAllRoleUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getRoleUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("createRoleUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteRoleUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("findRoleByNameUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateRoleUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
