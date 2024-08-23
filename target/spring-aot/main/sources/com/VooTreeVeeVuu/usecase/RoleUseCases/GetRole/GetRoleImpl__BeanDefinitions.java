package com.VooTreeVeeVuu.usecase.RoleUseCases.GetRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetRoleImpl}.
 */
@Generated
public class GetRoleImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getRoleImpl'.
   */
  public static BeanDefinition getGetRoleImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetRoleImpl.class);
    InstanceSupplier<GetRoleImpl> instanceSupplier = InstanceSupplier.using(GetRoleImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetRoleImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
