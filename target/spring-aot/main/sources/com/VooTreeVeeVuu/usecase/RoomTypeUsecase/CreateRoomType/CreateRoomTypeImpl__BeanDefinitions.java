package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.CreateRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateRoomTypeImpl}.
 */
@Generated
public class CreateRoomTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createRoomTypeImpl'.
   */
  public static BeanDefinition getCreateRoomTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateRoomTypeImpl.class);
    InstanceSupplier<CreateRoomTypeImpl> instanceSupplier = InstanceSupplier.using(CreateRoomTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateRoomTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
