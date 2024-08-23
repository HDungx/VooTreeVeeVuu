package com.VooTreeVeeVuu.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ApplicationConfig}.
 */
@Generated
public class ApplicationConfig__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ApplicationConfig apply(RegisteredBean registeredBean, ApplicationConfig instance) {
    AutowiredFieldValueResolver.forRequiredField("repository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
