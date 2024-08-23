package com.VooTreeVeeVuu.usecase.BookingUsecase.UpdateReviewStatus;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateReviewStatusImpl}.
 */
@Generated
public class UpdateReviewStatusImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateReviewStatusImpl apply(RegisteredBean registeredBean,
      UpdateReviewStatusImpl instance) {
    instance.bookingRepository = AutowiredFieldValueResolver.forRequiredField("bookingRepository").resolve(registeredBean);
    return instance;
  }
}
