package com.VooTreeVeeVuu.usecase.FacilityUsecase.GetAllFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllFacilityImpl}.
 */
@Generated
public class GetAllFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllFacilityImpl'.
   */
  public static BeanDefinition getGetAllFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllFacilityImpl.class);
    InstanceSupplier<GetAllFacilityImpl> instanceSupplier = InstanceSupplier.using(GetAllFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
