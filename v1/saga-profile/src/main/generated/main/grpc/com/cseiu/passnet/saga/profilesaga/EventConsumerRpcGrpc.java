package com.cseiu.passnet.saga.profilesaga;

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
public final class EventConsumerRpcGrpc {

  private EventConsumerRpcGrpc() {}

  public static final String SERVICE_NAME = "consumeEvents.EventConsumerRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf,
      com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConsumeUserRegisteredEvent",
      requestType = com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf.class,
      responseType = com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf,
      com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod() {
    io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf, com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getConsumeUserRegisteredEventMethod;
    if ((getConsumeUserRegisteredEventMethod = EventConsumerRpcGrpc.getConsumeUserRegisteredEventMethod) == null) {
      synchronized (EventConsumerRpcGrpc.class) {
        if ((getConsumeUserRegisteredEventMethod = EventConsumerRpcGrpc.getConsumeUserRegisteredEventMethod) == null) {
          EventConsumerRpcGrpc.getConsumeUserRegisteredEventMethod = getConsumeUserRegisteredEventMethod = 
              io.grpc.MethodDescriptor.<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf, com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "consumeEvents.EventConsumerRpc", "ConsumeUserRegisteredEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf.getDefaultInstance()))
                  .setSchemaDescriptor(new EventConsumerRpcMethodDescriptorSupplier("ConsumeUserRegisteredEvent"))
                  .build();
          }
        }
     }
     return getConsumeUserRegisteredEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventConsumerRpcStub newStub(io.grpc.Channel channel) {
    return new EventConsumerRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventConsumerRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EventConsumerRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventConsumerRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EventConsumerRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class EventConsumerRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void consumeUserRegisteredEvent(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeUserRegisteredEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConsumeUserRegisteredEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf,
                com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf>(
                  this, METHODID_CONSUME_USER_REGISTERED_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class EventConsumerRpcStub extends io.grpc.stub.AbstractStub<EventConsumerRpcStub> {
    private EventConsumerRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerRpcStub(channel, callOptions);
    }

    /**
     */
    public void consumeUserRegisteredEvent(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumeUserRegisteredEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventConsumerRpcBlockingStub extends io.grpc.stub.AbstractStub<EventConsumerRpcBlockingStub> {
    private EventConsumerRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf consumeUserRegisteredEvent(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf request) {
      return blockingUnaryCall(
          getChannel(), getConsumeUserRegisteredEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventConsumerRpcFutureStub extends io.grpc.stub.AbstractStub<EventConsumerRpcFutureStub> {
    private EventConsumerRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventConsumerRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventConsumerRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventConsumerRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> consumeUserRegisteredEvent(
        com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf request) {
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
    private final EventConsumerRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventConsumerRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUME_USER_REGISTERED_EVENT:
          serviceImpl.consumeUserRegisteredEvent((com.cseiu.passnet.saga.profilesaga.ConsumeEvents.UserRegisteredEventProtobuf) request,
              (io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf>) responseObserver);
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

  private static abstract class EventConsumerRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventConsumerRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cseiu.passnet.saga.profilesaga.ConsumeEvents.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventConsumerRpc");
    }
  }

  private static final class EventConsumerRpcFileDescriptorSupplier
      extends EventConsumerRpcBaseDescriptorSupplier {
    EventConsumerRpcFileDescriptorSupplier() {}
  }

  private static final class EventConsumerRpcMethodDescriptorSupplier
      extends EventConsumerRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventConsumerRpcMethodDescriptorSupplier(String methodName) {
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
      synchronized (EventConsumerRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventConsumerRpcFileDescriptorSupplier())
              .addMethod(getConsumeUserRegisteredEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
