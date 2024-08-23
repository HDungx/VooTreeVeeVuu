package com.VooTreeVeeVuu.usecase.HotelImageUsecase.GetAllHotelImage;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllHotelImageImpl}.
 */
@Generated
public class GetAllHotelImageImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllHotelImageImpl'.
   */
  public static BeanDefinition getGetAllHotelImageImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllHotelImageImpl.class);
    InstanceSupplier<GetAllHotelImageImpl> instanceSupplier = InstanceSupplier.using(GetAllHotelImageImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllHotelImageImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
