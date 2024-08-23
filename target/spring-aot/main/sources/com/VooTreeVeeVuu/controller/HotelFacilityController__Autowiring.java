package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link HotelFacilityController}.
 */
@Generated
public class HotelFacilityController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static HotelFacilityController apply(RegisteredBean registeredBean,
      HotelFacilityController instance) {
    AutowiredFieldValueResolver.forRequiredField("deleteHotelFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllHotelFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getHotelFacilityUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
