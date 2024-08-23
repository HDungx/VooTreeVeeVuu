package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetAllRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRoomFacilityImpl}.
 */
@Generated
public class GetAllRoomFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRoomFacilityImpl apply(RegisteredBean registeredBean,
      GetAllRoomFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
