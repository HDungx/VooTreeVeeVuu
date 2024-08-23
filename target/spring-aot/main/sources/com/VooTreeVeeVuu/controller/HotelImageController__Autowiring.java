package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link HotelImageController}.
 */
@Generated
public class HotelImageController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static HotelImageController apply(RegisteredBean registeredBean,
      HotelImageController instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelImageRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllHotelImage").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
