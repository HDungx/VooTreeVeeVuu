package com.VooTreeVeeVuu.usecase.FacilityUsecase.DeleteFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteFacilityImpl}.
 */
@Generated
public class DeleteFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteFacilityImpl'.
   */
  public static BeanDefinition getDeleteFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteFacilityImpl.class);
    InstanceSupplier<DeleteFacilityImpl> instanceSupplier = InstanceSupplier.using(DeleteFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
