package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.CreateAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateAccommodationTypeImpl}.
 */
@Generated
public class CreateAccommodationTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateAccommodationTypeImpl apply(RegisteredBean registeredBean,
      CreateAccommodationTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accommodationTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
