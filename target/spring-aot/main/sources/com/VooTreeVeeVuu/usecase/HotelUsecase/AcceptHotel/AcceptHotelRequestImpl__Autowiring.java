package com.VooTreeVeeVuu.usecase.HotelUsecase.AcceptHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AcceptHotelRequestImpl}.
 */
@Generated
public class AcceptHotelRequestImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AcceptHotelRequestImpl apply(RegisteredBean registeredBean,
      AcceptHotelRequestImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
