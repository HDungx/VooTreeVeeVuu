package com.VooTreeVeeVuu.usecase.RatingUsecase.GetAllRating;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRatingImpl}.
 */
@Generated
public class GetAllRatingImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRatingImpl apply(RegisteredBean registeredBean, GetAllRatingImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("ratingRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
