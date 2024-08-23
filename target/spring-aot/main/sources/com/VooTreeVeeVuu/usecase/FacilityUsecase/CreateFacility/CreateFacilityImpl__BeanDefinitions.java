package com.VooTreeVeeVuu.usecase.FacilityUsecase.CreateFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateFacilityImpl}.
 */
@Generated
public class CreateFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createFacilityImpl'.
   */
  public static BeanDefinition getCreateFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateFacilityImpl.class);
    InstanceSupplier<CreateFacilityImpl> instanceSupplier = InstanceSupplier.using(CreateFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
