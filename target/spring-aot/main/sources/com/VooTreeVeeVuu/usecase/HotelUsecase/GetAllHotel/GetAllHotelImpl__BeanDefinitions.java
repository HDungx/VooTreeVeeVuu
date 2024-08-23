package com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllHotelImpl}.
 */
@Generated
public class GetAllHotelImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllHotelImpl'.
   */
  public static BeanDefinition getGetAllHotelImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllHotelImpl.class);
    InstanceSupplier<GetAllHotelImpl> instanceSupplier = InstanceSupplier.using(GetAllHotelImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllHotelImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
