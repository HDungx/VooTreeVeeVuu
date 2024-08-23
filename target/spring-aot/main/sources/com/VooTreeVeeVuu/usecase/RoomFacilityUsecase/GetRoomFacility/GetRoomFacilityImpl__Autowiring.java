package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.GetRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetRoomFacilityImpl}.
 */
@Generated
public class GetRoomFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetRoomFacilityImpl apply(RegisteredBean registeredBean,
      GetRoomFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
