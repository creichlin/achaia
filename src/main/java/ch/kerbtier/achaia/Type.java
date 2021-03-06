package ch.kerbtier.achaia;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.Map;

public enum Type {
  MAP(Map.class, true), LIST(List.class, true), STRING(String.class, false), INTEGER(Integer.class, false), DATE(
      Date.class, false), BINARY(ByteBuffer.class, false), SLUG(Slug.class, false);

  private Class<?> javaType;
  private boolean container;

  Type(Class<?> javaType, boolean container) {
    this.javaType = javaType;
    this.container = container;
  }

  public Class<?> getJavaType() {
    return javaType;
  }
  
  public boolean isContainer() {
    return container;
  }

  public boolean isPrimitive() {
    return !container;
  }
}
