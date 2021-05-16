package com.cseiu.passnet.saga.classroomsaga;

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
  private static volatile io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent,
      com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeAcceptStudentApplicationEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConsumeAcceptStudentApplicationEvent",
      requestType = com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent.class,
      responseType = com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent,
      com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeAcceptStudentApplicationEventMethod() {
    io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent, com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeAcceptStudentApplicationEventMethod;
    if ((getConsumeAcceptStudentApplicationEventMethod = EventConsumerGrpc.getConsumeAcceptStudentApplicationEventMethod) == null) {
      synchronized (EventConsumerGrpc.class) {
        if ((getConsumeAcceptStudentApplicationEventMethod = EventConsumerGrpc.getConsumeAcceptStudentApplicationEventMethod) == null) {
          EventConsumerGrpc.getConsumeAcceptStudentApplicationEventMethod = getConsumeAcceptStudentApplicationEventMethod = 
              io.grpc.MethodDescriptor.<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent, com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "consumeEvents.EventConsumer", "ConsumeAcceptStudentApplicationEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EventConsumerMethodDescriptorSupplier("ConsumeAcceptStudentApplicationEvent"))
                  .build();
          }
        }
     }
     return getConsumeAcceptStudentApplicationEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent,
      com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeRemoveStudentApplicationEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConsumeRemoveStudentApplicationEvent",
      requestType = com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent.class,
      responseType = com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent,
      com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeRemoveStudentApplicationEventMethod() {
    io.grpc.MethodDescriptor<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent, com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> getConsumeRemoveStudentApplicationEventMethod;
    if ((getConsumeRemoveStudentApplicationEventMethod = EventConsumerGrpc.getConsumeRemoveStudentApplicationEventMethod) == null) {
      synchronized (EventConsumerGrpc.class) {
        if ((getConsumeRemoveStudentApplicationEventMethod = EventConsumerGrpc.getConsumeRemoveStudentApplicationEventMethod) == null) {
          EventConsumerGrpc.getConsumeRemoveStudentApplicationEventMethod = getConsumeRemoveStudentApplicationEventMethod = 
              io.grpc.MethodDescriptor.<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent, com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "consumeEvents.EventConsumer", "ConsumeRemoveStudentApplicationEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EventConsumerMethodDescriptorSupplier("ConsumeRemoveStudentApplicationEvent"))
                  .build();
          }
        }
     }
     return getConsumeRemoveStudentApplicationEventMethod;
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
    public void consumeAcceptStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeAcceptStudentApplicationEventMethod(), responseObserver);
    }

    /**
     */
    public void consumeRemoveStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeRemoveStudentApplicationEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConsumeAcceptStudentApplicationEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent,
                com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>(
                  this, METHODID_CONSUME_ACCEPT_STUDENT_APPLICATION_EVENT)))
          .addMethod(
            getConsumeRemoveStudentApplicationEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent,
                com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>(
                  this, METHODID_CONSUME_REMOVE_STUDENT_APPLICATION_EVENT)))
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
    public void consumeAcceptStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumeAcceptStudentApplicationEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void consumeRemoveStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumeRemoveStudentApplicationEventMethod(), getCallOptions()), request, responseObserver);
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
    public com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse consumeAcceptStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent request) {
      return blockingUnaryCall(
          getChannel(), getConsumeAcceptStudentApplicationEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse consumeRemoveStudentApplicationEvent(com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent request) {
      return blockingUnaryCall(
          getChannel(), getConsumeRemoveStudentApplicationEventMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> consumeAcceptStudentApplicationEvent(
        com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getConsumeAcceptStudentApplicationEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse> consumeRemoveStudentApplicationEvent(
        com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getConsumeRemoveStudentApplicationEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUME_ACCEPT_STUDENT_APPLICATION_EVENT = 0;
  private static final int METHODID_CONSUME_REMOVE_STUDENT_APPLICATION_EVENT = 1;

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
        case METHODID_CONSUME_ACCEPT_STUDENT_APPLICATION_EVENT:
          serviceImpl.consumeAcceptStudentApplicationEvent((com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.AcceptStudentApplicationEvent) request,
              (io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>) responseObserver);
          break;
        case METHODID_CONSUME_REMOVE_STUDENT_APPLICATION_EVENT:
          serviceImpl.consumeRemoveStudentApplicationEvent((com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.RemoveStudentApplicationEvent) request,
              (io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.ServiceResponse>) responseObserver);
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
      return com.cseiu.passnet.saga.classroomsaga.ConsumeEvents.getDescriptor();
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
              .addMethod(getConsumeAcceptStudentApplicationEventMethod())
              .addMethod(getConsumeRemoveStudentApplicationEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
