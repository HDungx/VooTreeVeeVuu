package com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateRoomImpl}.
 */
@Generated
public class CreateRoomImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createRoomImpl'.
   */
  public static BeanDefinition getCreateRoomImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateRoomImpl.class);
    InstanceSupplier<CreateRoomImpl> instanceSupplier = InstanceSupplier.using(CreateRoomImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateRoomImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
