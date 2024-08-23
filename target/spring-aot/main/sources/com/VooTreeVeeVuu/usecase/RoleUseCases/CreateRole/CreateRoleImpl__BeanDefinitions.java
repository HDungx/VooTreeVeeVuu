package com.VooTreeVeeVuu.usecase.RoleUseCases.CreateRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateRoleImpl}.
 */
@Generated
public class CreateRoleImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createRoleImpl'.
   */
  public static BeanDefinition getCreateRoleImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateRoleImpl.class);
    InstanceSupplier<CreateRoleImpl> instanceSupplier = InstanceSupplier.using(CreateRoleImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateRoleImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
