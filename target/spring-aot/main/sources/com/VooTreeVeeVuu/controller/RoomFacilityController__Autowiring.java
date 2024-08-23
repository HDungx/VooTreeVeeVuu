package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoomFacilityController}.
 */
@Generated
public class RoomFacilityController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoomFacilityController apply(RegisteredBean registeredBean,
      RoomFacilityController instance) {
    AutowiredFieldValueResolver.forRequiredField("deleteRoomFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllRoomFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getRoomFacilityUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
