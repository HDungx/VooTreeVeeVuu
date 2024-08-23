package com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateStatusHotelImpl}.
 */
@Generated
public class UpdateStatusHotelImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateStatusHotelImpl apply(RegisteredBean registeredBean,
      UpdateStatusHotelImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
