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
public final class CompensatingExecutorGrpc {

  private CompensatingExecutorGrpc() {}

  public static final String SERVICE_NAME = "consumeEvents.CompensatingExecutor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf,
      com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getRollbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rollback",
      requestType = com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf.class,
      responseType = com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf,
      com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getRollbackMethod() {
    io.grpc.MethodDescriptor<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf, com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> getRollbackMethod;
    if ((getRollbackMethod = CompensatingExecutorGrpc.getRollbackMethod) == null) {
      synchronized (CompensatingExecutorGrpc.class) {
        if ((getRollbackMethod = CompensatingExecutorGrpc.getRollbackMethod) == null) {
          CompensatingExecutorGrpc.getRollbackMethod = getRollbackMethod = 
              io.grpc.MethodDescriptor.<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf, com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "consumeEvents.CompensatingExecutor", "Rollback"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf.getDefaultInstance()))
                  .setSchemaDescriptor(new CompensatingExecutorMethodDescriptorSupplier("Rollback"))
                  .build();
          }
        }
     }
     return getRollbackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompensatingExecutorStub newStub(io.grpc.Channel channel) {
    return new CompensatingExecutorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompensatingExecutorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CompensatingExecutorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CompensatingExecutorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CompensatingExecutorFutureStub(channel);
  }

  /**
   */
  public static abstract class CompensatingExecutorImplBase implements io.grpc.BindableService {

    /**
     */
    public void rollback(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnimplementedUnaryCall(getRollbackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRollbackMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf,
                com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf>(
                  this, METHODID_ROLLBACK)))
          .build();
    }
  }

  /**
   */
  public static final class CompensatingExecutorStub extends io.grpc.stub.AbstractStub<CompensatingExecutorStub> {
    private CompensatingExecutorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompensatingExecutorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompensatingExecutorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompensatingExecutorStub(channel, callOptions);
    }

    /**
     */
    public void rollback(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf request,
        io.grpc.stub.StreamObserver<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CompensatingExecutorBlockingStub extends io.grpc.stub.AbstractStub<CompensatingExecutorBlockingStub> {
    private CompensatingExecutorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompensatingExecutorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompensatingExecutorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompensatingExecutorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf rollback(com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf request) {
      return blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CompensatingExecutorFutureStub extends io.grpc.stub.AbstractStub<CompensatingExecutorFutureStub> {
    private CompensatingExecutorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompensatingExecutorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompensatingExecutorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompensatingExecutorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cseiu.passnet.saga.profilesaga.ConsumeEvents.ServiceResponseProtobuf> rollback(
        com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf request) {
      return futureUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ROLLBACK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompensatingExecutorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompensatingExecutorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROLLBACK:
          serviceImpl.rollback((com.cseiu.passnet.saga.profilesaga.ConsumeEvents.EventIdProtobuf) request,
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

  private static abstract class CompensatingExecutorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompensatingExecutorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cseiu.passnet.saga.profilesaga.ConsumeEvents.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompensatingExecutor");
    }
  }

  private static final class CompensatingExecutorFileDescriptorSupplier
      extends CompensatingExecutorBaseDescriptorSupplier {
    CompensatingExecutorFileDescriptorSupplier() {}
  }

  private static final class CompensatingExecutorMethodDescriptorSupplier
      extends CompensatingExecutorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompensatingExecutorMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompensatingExecutorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CompensatingExecutorFileDescriptorSupplier())
              .addMethod(getRollbackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
