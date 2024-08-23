package com.VooTreeVeeVuu.usecase.BookingUsecase.GetAllBooking;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllBookingImpl}.
 */
@Generated
public class GetAllBookingImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllBookingImpl apply(RegisteredBean registeredBean, GetAllBookingImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("bookingRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
