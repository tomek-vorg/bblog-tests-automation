package api.services;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class JsonObjectMapper implements ObjectMapper {

  private final JSON json = new JSON();

  public static JsonObjectMapper create() {
    return new JsonObjectMapper();
  }

  @Override
  public Object deserialize(ObjectMapperDeserializationContext context) {
    return json.deserialize(context.getDataToDeserialize().asString(), context.getType());
  }

  @Override
  public Object serialize(ObjectMapperSerializationContext context) {
    return json.serialize(context.getObjectToSerialize());
  }
}
