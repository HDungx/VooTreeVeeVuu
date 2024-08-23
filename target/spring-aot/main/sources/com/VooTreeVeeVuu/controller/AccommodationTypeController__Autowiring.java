package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AccommodationTypeController}.
 */
@Generated
public class AccommodationTypeController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AccommodationTypeController apply(RegisteredBean registeredBean,
      AccommodationTypeController instance) {
    AutowiredFieldValueResolver.forRequiredField("createAccommodationTypeUsecase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateAccommodationTypeUsecase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteAccommodationTypeUsecase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllAccommodationTypeUsecase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAccommodationTypeUsecase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
