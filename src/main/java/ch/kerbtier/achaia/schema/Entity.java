package ch.kerbtier.achaia.schema;

import ch.kerbtier.achaia.Type;

public interface Entity {
  boolean is(Class<?> type);
  
  boolean is(Type type);

  Entity getParent();

  Type getType();
  
  String getName();
  
  /*
   * path is full path of model with list slot written as _
   */
  String getPath();
}
