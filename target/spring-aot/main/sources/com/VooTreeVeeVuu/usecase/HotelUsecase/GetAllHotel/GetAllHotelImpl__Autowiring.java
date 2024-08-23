package com.VooTreeVeeVuu.usecase.HotelUsecase.GetAllHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllHotelImpl}.
 */
@Generated
public class GetAllHotelImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllHotelImpl apply(RegisteredBean registeredBean, GetAllHotelImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
