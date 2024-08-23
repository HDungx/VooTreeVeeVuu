package com.VooTreeVeeVuu.usecase.FacilityUsecase.GetFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetFacilityImpl}.
 */
@Generated
public class GetFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getFacilityImpl'.
   */
  public static BeanDefinition getGetFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetFacilityImpl.class);
    InstanceSupplier<GetFacilityImpl> instanceSupplier = InstanceSupplier.using(GetFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
