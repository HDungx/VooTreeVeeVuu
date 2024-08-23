package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BookingController}.
 */
@Generated
public class BookingController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BookingController apply(RegisteredBean registeredBean, BookingController instance) {
    AutowiredFieldValueResolver.forRequiredField("getAllBookingUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getBookingUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("bookingService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateReviewStatus").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
