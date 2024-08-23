package com.VooTreeVeeVuu.usecase.LogsUsecase.UpdateLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateLogsImpl}.
 */
@Generated
public class UpdateLogsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateLogsImpl apply(RegisteredBean registeredBean, UpdateLogsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("logsRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
