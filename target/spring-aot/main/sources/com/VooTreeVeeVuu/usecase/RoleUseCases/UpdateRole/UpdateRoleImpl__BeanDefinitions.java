package com.VooTreeVeeVuu.usecase.RoleUseCases.UpdateRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateRoleImpl}.
 */
@Generated
public class UpdateRoleImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateRoleImpl'.
   */
  public static BeanDefinition getUpdateRoleImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateRoleImpl.class);
    InstanceSupplier<UpdateRoleImpl> instanceSupplier = InstanceSupplier.using(UpdateRoleImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateRoleImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
