package com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRoomImpl}.
 */
@Generated
public class GetAllRoomImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRoomImpl'.
   */
  public static BeanDefinition getGetAllRoomImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRoomImpl.class);
    InstanceSupplier<GetAllRoomImpl> instanceSupplier = InstanceSupplier.using(GetAllRoomImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRoomImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
