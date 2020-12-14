package api.services;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.GsonFireBuilder;
import okio.ByteString;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class JSON {

  private final OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
  private final LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();

  private Gson gson;

  public JSON() {
    gson = new GsonFireBuilder().createGsonBuilder()
      .serializeNulls()
      .registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter)
      .registerTypeAdapter(LocalDate.class, localDateTypeAdapter)
      .registerTypeAdapter(byte[].class, new ByteArrayAdapter())
      .create();
  }

  /**
   * Get Gson.
   *
   * @return Gson
   */
  public Gson getGson() {
    return gson;
  }

  /**
   * Set Gson.
   *
   * @param gson Gson
   * @return JSON
   */
  public JSON setGson(Gson gson) {
    this.gson = gson;
    return this;
  }

  /**
   * Serialize the given Java object into JSON string.
   *
   * @param obj Object
   * @return String representation of the JSON
   */
  public String serialize(Object obj) {
    return gson.toJson(obj);
  }

  /**
   * Deserialize the given JSON string to Java object.
   *
   * @param <T>        Type
   * @param body       The JSON string
   * @param returnType The type to deserialize into
   * @return The deserialized Java object
   */
  @SuppressWarnings("unchecked")
  public <T> T deserialize(String body, Type returnType) {
    try {
      return gson.fromJson(body, returnType);
    } catch (JsonParseException e) {
      // Fallback processing when failed to parse JSON form response body:
      // return the response body string directly for the String return type;
      if (returnType.equals(String.class))
        return (T) body;
      else throw (e);
    }
  }

  public JSON setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
    offsetDateTimeTypeAdapter.setFormat(dateFormat);
    return this;
  }

  public JSON setLocalDateFormat(DateTimeFormatter dateFormat) {
    localDateTypeAdapter.setFormat(dateFormat);
    return this;
  }

  /**
   * Gson TypeAdapter for JSR310 OffsetDateTime type
   */
  public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

    private DateTimeFormatter formatter;

    public OffsetDateTimeTypeAdapter() {
      this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
      this.formatter = formatter;
    }

    public void setFormat(DateTimeFormatter dateFormat) {
      this.formatter = dateFormat;
    }

    @Override
    public void write(JsonWriter out, OffsetDateTime date) throws IOException {
      if (date == null) {
        out.nullValue();
      } else {
        out.value(formatter.format(date));
      }
    }

    @Override
    public OffsetDateTime read(JsonReader in) throws IOException {
      switch (in.peek()) {
        case NULL:
          in.nextNull();
          return null;
        default:
          String date = in.nextString();
          if (date.endsWith("+0000")) {
            date = date.substring(0, date.length() - 5) + "Z";
          }
          return OffsetDateTime.parse(date, formatter);
      }
    }
  }

  /**
   * Gson TypeAdapter for Byte Array type
   */
  public class ByteArrayAdapter extends TypeAdapter<byte[]> {

    @Override
    public void write(JsonWriter out, byte[] value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        out.value(ByteString.of(value).base64());
      }
    }

    @Override
    public byte[] read(JsonReader in) throws IOException {
      switch (in.peek()) {
        case NULL:
          in.nextNull();
          return null;
        default:
          String bytesAsBase64 = in.nextString();
          ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
          return byteString.toByteArray();
      }
    }
  }

  /**
   * Gson TypeAdapter for JSR310 LocalDate type
   */
  public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

    private DateTimeFormatter formatter;

    public LocalDateTypeAdapter() {
      this(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public LocalDateTypeAdapter(DateTimeFormatter formatter) {
      this.formatter = formatter;
    }

    public void setFormat(DateTimeFormatter dateFormat) {
      this.formatter = dateFormat;
    }

    @Override
    public void write(JsonWriter out, LocalDate date) throws IOException {
      if (date == null) {
        out.nullValue();
      } else {
        out.value(formatter.format(date));
      }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
      switch (in.peek()) {
        case NULL:
          in.nextNull();
          return null;
        default:
          String date = in.nextString();
          return LocalDate.parse(date, formatter);
      }
    }
  }
}
