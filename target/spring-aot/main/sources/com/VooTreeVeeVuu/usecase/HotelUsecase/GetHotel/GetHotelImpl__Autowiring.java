package com.VooTreeVeeVuu.usecase.HotelUsecase.GetHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetHotelImpl}.
 */
@Generated
public class GetHotelImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetHotelImpl apply(RegisteredBean registeredBean, GetHotelImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
