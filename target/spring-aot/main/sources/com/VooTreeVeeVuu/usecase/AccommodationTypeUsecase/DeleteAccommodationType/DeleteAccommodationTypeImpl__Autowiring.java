package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.DeleteAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteAccommodationTypeImpl}.
 */
@Generated
public class DeleteAccommodationTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteAccommodationTypeImpl apply(RegisteredBean registeredBean,
      DeleteAccommodationTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accommodationTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
