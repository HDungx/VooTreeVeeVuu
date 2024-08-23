package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetAllHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllHotelFacilityImpl}.
 */
@Generated
public class GetAllHotelFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllHotelFacilityImpl'.
   */
  public static BeanDefinition getGetAllHotelFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllHotelFacilityImpl.class);
    InstanceSupplier<GetAllHotelFacilityImpl> instanceSupplier = InstanceSupplier.using(GetAllHotelFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllHotelFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
