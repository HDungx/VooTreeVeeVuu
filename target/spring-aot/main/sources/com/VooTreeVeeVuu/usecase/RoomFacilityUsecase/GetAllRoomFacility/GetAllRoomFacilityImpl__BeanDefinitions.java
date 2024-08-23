package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetAllRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRoomFacilityImpl}.
 */
@Generated
public class GetAllRoomFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRoomFacilityImpl'.
   */
  public static BeanDefinition getGetAllRoomFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRoomFacilityImpl.class);
    InstanceSupplier<GetAllRoomFacilityImpl> instanceSupplier = InstanceSupplier.using(GetAllRoomFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRoomFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
