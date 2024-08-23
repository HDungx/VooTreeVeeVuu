package com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetHotelImpl}.
 */
@Generated
public class GetHotelImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getHotelImpl'.
   */
  public static BeanDefinition getGetHotelImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetHotelImpl.class);
    InstanceSupplier<GetHotelImpl> instanceSupplier = InstanceSupplier.using(GetHotelImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetHotelImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
