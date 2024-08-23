package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link LogsController}.
 */
@Generated
public class LogsController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static LogsController apply(RegisteredBean registeredBean, LogsController instance) {
    AutowiredFieldValueResolver.forRequiredField("createLogsUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateLogsUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteLogsUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllLogsUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getLogsUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
