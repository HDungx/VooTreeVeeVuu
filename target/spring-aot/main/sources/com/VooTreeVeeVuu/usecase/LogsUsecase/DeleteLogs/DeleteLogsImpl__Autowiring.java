package com.VooTreeVeeVuu.usecase.LogsUsecase.DeleteLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteLogsImpl}.
 */
@Generated
public class DeleteLogsImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteLogsImpl apply(RegisteredBean registeredBean, DeleteLogsImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("logsRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
