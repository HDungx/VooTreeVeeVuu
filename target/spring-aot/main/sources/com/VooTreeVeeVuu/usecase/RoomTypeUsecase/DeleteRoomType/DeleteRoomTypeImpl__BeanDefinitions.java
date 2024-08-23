package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.DeleteRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteRoomTypeImpl}.
 */
@Generated
public class DeleteRoomTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteRoomTypeImpl'.
   */
  public static BeanDefinition getDeleteRoomTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteRoomTypeImpl.class);
    InstanceSupplier<DeleteRoomTypeImpl> instanceSupplier = InstanceSupplier.using(DeleteRoomTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteRoomTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
