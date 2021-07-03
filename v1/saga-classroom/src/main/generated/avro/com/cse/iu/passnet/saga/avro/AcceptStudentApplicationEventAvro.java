/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cse.iu.passnet.saga.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AcceptStudentApplicationEventAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1747459395256196004L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AcceptStudentApplicationEventAvro\",\"namespace\":\"com.cse.iu.passnet.saga.avro\",\"fields\":[{\"name\":\"job_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Job ID\"},{\"name\":\"ta_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"TA ID\"},{\"name\":\"event_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Event ID\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AcceptStudentApplicationEventAvro> ENCODER =
      new BinaryMessageEncoder<AcceptStudentApplicationEventAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AcceptStudentApplicationEventAvro> DECODER =
      new BinaryMessageDecoder<AcceptStudentApplicationEventAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AcceptStudentApplicationEventAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AcceptStudentApplicationEventAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AcceptStudentApplicationEventAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AcceptStudentApplicationEventAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AcceptStudentApplicationEventAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AcceptStudentApplicationEventAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AcceptStudentApplicationEventAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AcceptStudentApplicationEventAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Job ID */
   private java.lang.String job_id;
  /** TA ID */
   private java.lang.String ta_id;
  /** Event ID */
   private java.lang.String event_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AcceptStudentApplicationEventAvro() {}

  /**
   * All-args constructor.
   * @param job_id Job ID
   * @param ta_id TA ID
   * @param event_id Event ID
   */
  public AcceptStudentApplicationEventAvro(java.lang.String job_id, java.lang.String ta_id, java.lang.String event_id) {
    this.job_id = job_id;
    this.ta_id = ta_id;
    this.event_id = event_id;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return job_id;
    case 1: return ta_id;
    case 2: return event_id;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: job_id = value$ != null ? value$.toString() : null; break;
    case 1: ta_id = value$ != null ? value$.toString() : null; break;
    case 2: event_id = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'job_id' field.
   * @return Job ID
   */
  public java.lang.String getJobId() {
    return job_id;
  }



  /**
   * Gets the value of the 'ta_id' field.
   * @return TA ID
   */
  public java.lang.String getTaId() {
    return ta_id;
  }



  /**
   * Gets the value of the 'event_id' field.
   * @return Event ID
   */
  public java.lang.String getEventId() {
    return event_id;
  }



  /**
   * Creates a new AcceptStudentApplicationEventAvro RecordBuilder.
   * @return A new AcceptStudentApplicationEventAvro RecordBuilder
   */
  public static com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder newBuilder() {
    return new com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder();
  }

  /**
   * Creates a new AcceptStudentApplicationEventAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AcceptStudentApplicationEventAvro RecordBuilder
   */
  public static com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder newBuilder(com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder other) {
    if (other == null) {
      return new com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder();
    } else {
      return new com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder(other);
    }
  }

  /**
   * Creates a new AcceptStudentApplicationEventAvro RecordBuilder by copying an existing AcceptStudentApplicationEventAvro instance.
   * @param other The existing instance to copy.
   * @return A new AcceptStudentApplicationEventAvro RecordBuilder
   */
  public static com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder newBuilder(com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro other) {
    if (other == null) {
      return new com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder();
    } else {
      return new com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for AcceptStudentApplicationEventAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AcceptStudentApplicationEventAvro>
    implements org.apache.avro.data.RecordBuilder<AcceptStudentApplicationEventAvro> {

    /** Job ID */
    private java.lang.String job_id;
    /** TA ID */
    private java.lang.String ta_id;
    /** Event ID */
    private java.lang.String event_id;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.job_id)) {
        this.job_id = data().deepCopy(fields()[0].schema(), other.job_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.ta_id)) {
        this.ta_id = data().deepCopy(fields()[1].schema(), other.ta_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.event_id)) {
        this.event_id = data().deepCopy(fields()[2].schema(), other.event_id);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing AcceptStudentApplicationEventAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.job_id)) {
        this.job_id = data().deepCopy(fields()[0].schema(), other.job_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ta_id)) {
        this.ta_id = data().deepCopy(fields()[1].schema(), other.ta_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.event_id)) {
        this.event_id = data().deepCopy(fields()[2].schema(), other.event_id);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'job_id' field.
      * Job ID
      * @return The value.
      */
    public java.lang.String getJobId() {
      return job_id;
    }


    /**
      * Sets the value of the 'job_id' field.
      * Job ID
      * @param value The value of 'job_id'.
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder setJobId(java.lang.String value) {
      validate(fields()[0], value);
      this.job_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'job_id' field has been set.
      * Job ID
      * @return True if the 'job_id' field has been set, false otherwise.
      */
    public boolean hasJobId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'job_id' field.
      * Job ID
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder clearJobId() {
      job_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'ta_id' field.
      * TA ID
      * @return The value.
      */
    public java.lang.String getTaId() {
      return ta_id;
    }


    /**
      * Sets the value of the 'ta_id' field.
      * TA ID
      * @param value The value of 'ta_id'.
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder setTaId(java.lang.String value) {
      validate(fields()[1], value);
      this.ta_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'ta_id' field has been set.
      * TA ID
      * @return True if the 'ta_id' field has been set, false otherwise.
      */
    public boolean hasTaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'ta_id' field.
      * TA ID
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder clearTaId() {
      ta_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_id' field.
      * Event ID
      * @return The value.
      */
    public java.lang.String getEventId() {
      return event_id;
    }


    /**
      * Sets the value of the 'event_id' field.
      * Event ID
      * @param value The value of 'event_id'.
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder setEventId(java.lang.String value) {
      validate(fields()[2], value);
      this.event_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'event_id' field has been set.
      * Event ID
      * @return True if the 'event_id' field has been set, false otherwise.
      */
    public boolean hasEventId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'event_id' field.
      * Event ID
      * @return This builder.
      */
    public com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro.Builder clearEventId() {
      event_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AcceptStudentApplicationEventAvro build() {
      try {
        AcceptStudentApplicationEventAvro record = new AcceptStudentApplicationEventAvro();
        record.job_id = fieldSetFlags()[0] ? this.job_id : (java.lang.String) defaultValue(fields()[0]);
        record.ta_id = fieldSetFlags()[1] ? this.ta_id : (java.lang.String) defaultValue(fields()[1]);
        record.event_id = fieldSetFlags()[2] ? this.event_id : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AcceptStudentApplicationEventAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<AcceptStudentApplicationEventAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AcceptStudentApplicationEventAvro>
    READER$ = (org.apache.avro.io.DatumReader<AcceptStudentApplicationEventAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.job_id);

    out.writeString(this.ta_id);

    out.writeString(this.event_id);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.job_id = in.readString();

      this.ta_id = in.readString();

      this.event_id = in.readString();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.job_id = in.readString();
          break;

        case 1:
          this.ta_id = in.readString();
          break;

        case 2:
          this.event_id = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










