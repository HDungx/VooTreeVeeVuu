package com.VooTreeVeeVuu.usecase.RatingUsecase.GetRatingForHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetRatingForHotelImpl}.
 */
@Generated
public class GetRatingForHotelImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetRatingForHotelImpl apply(RegisteredBean registeredBean,
      GetRatingForHotelImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("ratingRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
