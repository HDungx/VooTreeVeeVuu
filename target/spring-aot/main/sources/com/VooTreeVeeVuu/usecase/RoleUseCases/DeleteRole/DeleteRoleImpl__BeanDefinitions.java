package com.VooTreeVeeVuu.usecase.RoleUseCases.DeleteRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteRoleImpl}.
 */
@Generated
public class DeleteRoleImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteRoleImpl'.
   */
  public static BeanDefinition getDeleteRoleImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteRoleImpl.class);
    InstanceSupplier<DeleteRoleImpl> instanceSupplier = InstanceSupplier.using(DeleteRoleImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteRoleImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
