package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.DeleteHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteHotelFacilityImpl}.
 */
@Generated
public class DeleteHotelFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteHotelFacilityImpl'.
   */
  public static BeanDefinition getDeleteHotelFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteHotelFacilityImpl.class);
    InstanceSupplier<DeleteHotelFacilityImpl> instanceSupplier = InstanceSupplier.using(DeleteHotelFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteHotelFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
