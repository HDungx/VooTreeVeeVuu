package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BookingService}.
 */
@Generated
public class BookingService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BookingService apply(RegisteredBean registeredBean, BookingService instance) {
    AutowiredFieldValueResolver.forRequiredField("bookingRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
