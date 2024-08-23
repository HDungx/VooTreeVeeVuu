package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link HotelController}.
 */
@Generated
public class HotelController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static HotelController apply(RegisteredBean registeredBean, HotelController instance) {
    AutowiredFieldValueResolver.forRequiredField("getAllHotelUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getHotelUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteHotelUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateStatusHotelUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("hotelService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("acceptHotelRequest").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
