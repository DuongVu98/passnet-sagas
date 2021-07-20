package com.cseiu.passnet.saga.organizersaga;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: consume-events.proto")
public final class EventConsumerGrpc {

  private EventConsumerGrpc() {}

  public static final String SERVICE_NAME = "consumeEvents.EventConsumer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf,
      com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConsumeUserRegisteredEvent",
      requestType = com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf.class,
      responseType = com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf,
      com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod() {
    io.grpc.MethodDescriptor<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf, com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod;
    if ((getConsumeUserRegisteredEventMethod = EventConsumerGrpc.getConsumeUserRegisteredEventMethod) == null) {
      synchronized (EventConsumerGrpc.class) {
        if ((getConsumeUserRegisteredEventMethod = EventConsumerGrpc.getConsumeUserRegisteredEventMethod) == null) {
          EventConsumerGrpc.getConsumeUserRegisteredEventMethod = getConsumeUserRegisteredEventMethod = 
              io.grpc.MethodDescriptor.<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf, com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "consumeEvents.EventConsumer", "ConsumeUserRegisteredEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf.getDefaultInstance()))
                  .setSchemaDescriptor(new EventConsumerMethodDescriptorSupplier("ConsumeUserRegisteredEvent"))
                  .build();
          }
        }
     }
     return getConsumeUserRegisteredEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventConsumerStub newStub(io.grpc.Channel channel) {
    return new EventConsumerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventConsumerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EventConsumerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventConsumerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EventConsumerFutureStub(channel);
  }

  /**
   */
  public static abstract class EventConsumerImplBase implements io.grpc.BindableService {

    /**
     */
    public void consumeUserRegisteredEvent(com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeUserRegisteredEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConsumeUserRegisteredEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf,
                com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf>(
                  this, METHODID_CONSUME_USER_REGISTERED_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class EventConsumerStub extends io.grpc.stub.AbstractStub<EventConsumerStub> {
    private EventConsumerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerStub(channel, callOptions);
    }

    /**
     */
    public void consumeUserRegisteredEvent(com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumeUserRegisteredEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventConsumerBlockingStub extends io.grpc.stub.AbstractStub<EventConsumerBlockingStub> {
    private EventConsumerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf consumeUserRegisteredEvent(com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf request) {
      return blockingUnaryCall(
          getChannel(), getConsumeUserRegisteredEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventConsumerFutureStub extends io.grpc.stub.AbstractStub<EventConsumerFutureStub> {
    private EventConsumerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf> consumeUserRegisteredEvent(
        com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf request) {
      return futureUnaryCall(
          getChannel().newCall(getConsumeUserRegisteredEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUME_USER_REGISTERED_EVENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventConsumerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventConsumerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUME_USER_REGISTERED_EVENT:
          serviceImpl.consumeUserRegisteredEvent((com.cseiu.passnet.saga.organizersaga.ConsumeEvents.UserRegisteredEventProtobuf) request,
              (io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.organizersaga.ConsumeEvents.ServiceResponseProtobuf>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EventConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventConsumerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cseiu.passnet.saga.organizersaga.ConsumeEvents.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventConsumer");
    }
  }

  private static final class EventConsumerFileDescriptorSupplier
      extends EventConsumerBaseDescriptorSupplier {
    EventConsumerFileDescriptorSupplier() {}
  }

  private static final class EventConsumerMethodDescriptorSupplier
      extends EventConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventConsumerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventConsumerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventConsumerFileDescriptorSupplier())
              .addMethod(getConsumeUserRegisteredEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
