package com.function;

import com.microsoft.azure.functions.annotation.*;

import java.util.Map;

import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Service Bus Trigger.
 */
public class ServiceBusQueueTriggerJava1 {
    /**
     * This function will be invoked when a new message is received at the Service Bus Queue.
     */
    @FunctionName("ServiceBusQueueTriggerJava1")
    public void run(
            @ServiceBusQueueTrigger(name = "message", queueName = "myinputqueue", connection = "connectionstring_SERVICEBUS") String message,
            @BindingName("ApplicationProperties") Map<String, Object> properties,
            final ExecutionContext context
    ) {
        context.getLogger().info("Java Service Bus Queue trigger function executed.");
        context.getLogger().info(message);
        context.getLogger().info(context.getInvocationId());
        System.out.println(properties);
    }
}
