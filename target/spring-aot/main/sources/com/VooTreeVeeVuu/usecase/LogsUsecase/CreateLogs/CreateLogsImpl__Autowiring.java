package com.VooTreeVeeVuu.usecase.LogsUsecase.CreateLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateLogsImpl}.
 */
@Generated
public class CreateLogsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateLogsImpl apply(RegisteredBean registeredBean, CreateLogsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("logsRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
