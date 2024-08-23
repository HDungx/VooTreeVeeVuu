package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAllAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllAccommodationTypeImpl}.
 */
@Generated
public class GetAllAccommodationTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllAccommodationTypeImpl'.
   */
  public static BeanDefinition getGetAllAccommodationTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllAccommodationTypeImpl.class);
    InstanceSupplier<GetAllAccommodationTypeImpl> instanceSupplier = InstanceSupplier.using(GetAllAccommodationTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllAccommodationTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
