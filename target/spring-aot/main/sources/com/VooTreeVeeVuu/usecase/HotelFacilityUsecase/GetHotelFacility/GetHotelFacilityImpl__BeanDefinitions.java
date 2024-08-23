package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetHotelFacilityImpl}.
 */
@Generated
public class GetHotelFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getHotelFacilityImpl'.
   */
  public static BeanDefinition getGetHotelFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetHotelFacilityImpl.class);
    InstanceSupplier<GetHotelFacilityImpl> instanceSupplier = InstanceSupplier.using(GetHotelFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetHotelFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
