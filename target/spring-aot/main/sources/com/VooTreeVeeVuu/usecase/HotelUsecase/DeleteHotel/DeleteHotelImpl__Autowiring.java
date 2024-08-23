package com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteHotelImpl}.
 */
@Generated
public class DeleteHotelImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteHotelImpl apply(RegisteredBean registeredBean, DeleteHotelImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
