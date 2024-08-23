package com.VooTreeVeeVuu.usecase.BookingUsecase.GetBooking;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetBookingImpl}.
 */
@Generated
public class GetBookingImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetBookingImpl apply(RegisteredBean registeredBean, GetBookingImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("bookingRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
