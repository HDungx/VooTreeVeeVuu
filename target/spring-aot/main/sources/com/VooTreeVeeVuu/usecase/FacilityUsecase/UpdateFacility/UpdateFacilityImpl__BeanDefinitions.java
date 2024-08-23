package com.VooTreeVeeVuu.usecase.FacilityUsecase.UpdateFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateFacilityImpl}.
 */
@Generated
public class UpdateFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateFacilityImpl'.
   */
  public static BeanDefinition getUpdateFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateFacilityImpl.class);
    InstanceSupplier<UpdateFacilityImpl> instanceSupplier = InstanceSupplier.using(UpdateFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
