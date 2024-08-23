package com.VooTreeVeeVuu.usecase.LogsUsecase.GetAllLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllLogsImpl}.
 */
@Generated
public class GetAllLogsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllLogsImpl apply(RegisteredBean registeredBean, GetAllLogsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("logsRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
