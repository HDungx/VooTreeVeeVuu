package com.VooTreeVeeVuu.usecase.LogsUsecase.GetLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetLogsImpl}.
 */
@Generated
public class GetLogsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetLogsImpl apply(RegisteredBean registeredBean, GetLogsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("logsRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
