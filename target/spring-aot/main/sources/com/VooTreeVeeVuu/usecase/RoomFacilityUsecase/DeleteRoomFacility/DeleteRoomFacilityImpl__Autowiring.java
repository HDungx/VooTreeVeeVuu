package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.DeleteRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteRoomFacilityImpl}.
 */
@Generated
public class DeleteRoomFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteRoomFacilityImpl apply(RegisteredBean registeredBean,
      DeleteRoomFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
