package com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetAllRoomImage;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRoomImageImpl}.
 */
@Generated
public class GetAllRoomImageImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRoomImageImpl'.
   */
  public static BeanDefinition getGetAllRoomImageImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRoomImageImpl.class);
    InstanceSupplier<GetAllRoomImageImpl> instanceSupplier = InstanceSupplier.using(GetAllRoomImageImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRoomImageImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
