package com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetRoomImpl}.
 */
@Generated
public class GetRoomImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getRoomImpl'.
   */
  public static BeanDefinition getGetRoomImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetRoomImpl.class);
    InstanceSupplier<GetRoomImpl> instanceSupplier = InstanceSupplier.using(GetRoomImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetRoomImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
