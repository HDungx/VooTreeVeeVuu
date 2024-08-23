package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoomService}.
 */
@Generated
public class RoomService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoomService apply(RegisteredBean registeredBean, RoomService instance) {
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomFacilityRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomImageRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
