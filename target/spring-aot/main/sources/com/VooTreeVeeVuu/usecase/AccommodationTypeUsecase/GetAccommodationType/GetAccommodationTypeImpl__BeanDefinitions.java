package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAccommodationTypeImpl}.
 */
@Generated
public class GetAccommodationTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAccommodationTypeImpl'.
   */
  public static BeanDefinition getGetAccommodationTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAccommodationTypeImpl.class);
    InstanceSupplier<GetAccommodationTypeImpl> instanceSupplier = InstanceSupplier.using(GetAccommodationTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAccommodationTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
