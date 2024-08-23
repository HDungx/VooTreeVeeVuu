package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RatingController}.
 */
@Generated
public class RatingController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RatingController apply(RegisteredBean registeredBean, RatingController instance) {
    AutowiredFieldValueResolver.forRequiredField("createRatingUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllRatingUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getRatingsForHotel").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
