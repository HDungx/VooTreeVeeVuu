package com.VooTreeVeeVuu.usecase.RoleUseCases.GetAllRole;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRoleImpl}.
 */
@Generated
public class GetAllRoleImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRoleImpl'.
   */
  public static BeanDefinition getGetAllRoleImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRoleImpl.class);
    InstanceSupplier<GetAllRoleImpl> instanceSupplier = InstanceSupplier.using(GetAllRoleImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRoleImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
