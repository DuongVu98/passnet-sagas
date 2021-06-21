package proto;

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
    comments = "Source: produce-event.proto")
public final class EventProducerGrpc {

  private EventProducerGrpc() {}

  public static final String SERVICE_NAME = "proto.EventProducer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ProduceEvent.UserRegisteredEvent,
      proto.ProduceEvent.SagaResponse> getProduceUserRegisteredEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProduceUserRegisteredEvent",
      requestType = proto.ProduceEvent.UserRegisteredEvent.class,
      responseType = proto.ProduceEvent.SagaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ProduceEvent.UserRegisteredEvent,
      proto.ProduceEvent.SagaResponse> getProduceUserRegisteredEventMethod() {
    io.grpc.MethodDescriptor<proto.ProduceEvent.UserRegisteredEvent, proto.ProduceEvent.SagaResponse> getProduceUserRegisteredEventMethod;
    if ((getProduceUserRegisteredEventMethod = EventProducerGrpc.getProduceUserRegisteredEventMethod) == null) {
      synchronized (EventProducerGrpc.class) {
        if ((getProduceUserRegisteredEventMethod = EventProducerGrpc.getProduceUserRegisteredEventMethod) == null) {
          EventProducerGrpc.getProduceUserRegisteredEventMethod = getProduceUserRegisteredEventMethod = 
              io.grpc.MethodDescriptor.<proto.ProduceEvent.UserRegisteredEvent, proto.ProduceEvent.SagaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.EventProducer", "ProduceUserRegisteredEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ProduceEvent.UserRegisteredEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ProduceEvent.SagaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EventProducerMethodDescriptorSupplier("ProduceUserRegisteredEvent"))
                  .build();
          }
        }
     }
     return getProduceUserRegisteredEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventProducerStub newStub(io.grpc.Channel channel) {
    return new EventProducerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventProducerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EventProducerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventProducerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EventProducerFutureStub(channel);
  }

  /**
   */
  public static abstract class EventProducerImplBase implements io.grpc.BindableService {

    /**
     */
    public void produceUserRegisteredEvent(proto.ProduceEvent.UserRegisteredEvent request,
        io.grpc.stub.StreamObserver<proto.ProduceEvent.SagaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProduceUserRegisteredEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProduceUserRegisteredEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.ProduceEvent.UserRegisteredEvent,
                proto.ProduceEvent.SagaResponse>(
                  this, METHODID_PRODUCE_USER_REGISTERED_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class EventProducerStub extends io.grpc.stub.AbstractStub<EventProducerStub> {
    private EventProducerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventProducerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventProducerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventProducerStub(channel, callOptions);
    }

    /**
     */
    public void produceUserRegisteredEvent(proto.ProduceEvent.UserRegisteredEvent request,
        io.grpc.stub.StreamObserver<proto.ProduceEvent.SagaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProduceUserRegisteredEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventProducerBlockingStub extends io.grpc.stub.AbstractStub<EventProducerBlockingStub> {
    private EventProducerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventProducerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventProducerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventProducerBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ProduceEvent.SagaResponse produceUserRegisteredEvent(proto.ProduceEvent.UserRegisteredEvent request) {
      return blockingUnaryCall(
          getChannel(), getProduceUserRegisteredEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventProducerFutureStub extends io.grpc.stub.AbstractStub<EventProducerFutureStub> {
    private EventProducerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventProducerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventProducerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventProducerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ProduceEvent.SagaResponse> produceUserRegisteredEvent(
        proto.ProduceEvent.UserRegisteredEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getProduceUserRegisteredEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRODUCE_USER_REGISTERED_EVENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventProducerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventProducerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRODUCE_USER_REGISTERED_EVENT:
          serviceImpl.produceUserRegisteredEvent((proto.ProduceEvent.UserRegisteredEvent) request,
              (io.grpc.stub.StreamObserver<proto.ProduceEvent.SagaResponse>) responseObserver);
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

  private static abstract class EventProducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventProducerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ProduceEvent.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventProducer");
    }
  }

  private static final class EventProducerFileDescriptorSupplier
      extends EventProducerBaseDescriptorSupplier {
    EventProducerFileDescriptorSupplier() {}
  }

  private static final class EventProducerMethodDescriptorSupplier
      extends EventProducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventProducerMethodDescriptorSupplier(String methodName) {
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
      synchronized (EventProducerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventProducerFileDescriptorSupplier())
              .addMethod(getProduceUserRegisteredEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
