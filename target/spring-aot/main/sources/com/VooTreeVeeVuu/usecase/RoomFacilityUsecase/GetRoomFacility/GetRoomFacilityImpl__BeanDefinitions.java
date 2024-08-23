package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetRoomFacilityImpl}.
 */
@Generated
public class GetRoomFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getRoomFacilityImpl'.
   */
  public static BeanDefinition getGetRoomFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetRoomFacilityImpl.class);
    InstanceSupplier<GetRoomFacilityImpl> instanceSupplier = InstanceSupplier.using(GetRoomFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetRoomFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
