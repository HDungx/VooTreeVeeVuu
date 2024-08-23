package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.CreateAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateAccommodationTypeImpl}.
 */
@Generated
public class CreateAccommodationTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createAccommodationTypeImpl'.
   */
  public static BeanDefinition getCreateAccommodationTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateAccommodationTypeImpl.class);
    InstanceSupplier<CreateAccommodationTypeImpl> instanceSupplier = InstanceSupplier.using(CreateAccommodationTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateAccommodationTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
