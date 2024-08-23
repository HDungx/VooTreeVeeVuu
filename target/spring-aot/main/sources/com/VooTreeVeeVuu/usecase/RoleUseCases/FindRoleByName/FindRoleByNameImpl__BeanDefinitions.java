package com.VooTreeVeeVuu.usecase.RoleUseCases.FindRoleByName;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FindRoleByNameImpl}.
 */
@Generated
public class FindRoleByNameImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'findRoleByNameImpl'.
   */
  public static BeanDefinition getFindRoleByNameImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FindRoleByNameImpl.class);
    InstanceSupplier<FindRoleByNameImpl> instanceSupplier = InstanceSupplier.using(FindRoleByNameImpl::new);
    instanceSupplier = instanceSupplier.andThen(FindRoleByNameImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
