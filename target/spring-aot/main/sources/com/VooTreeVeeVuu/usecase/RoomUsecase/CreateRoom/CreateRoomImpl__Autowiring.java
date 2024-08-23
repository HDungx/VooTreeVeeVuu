package com.VooTreeVeeVuu.usecase.RoomUsecase.CreateRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateRoomImpl}.
 */
@Generated
public class CreateRoomImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateRoomImpl apply(RegisteredBean registeredBean, CreateRoomImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
