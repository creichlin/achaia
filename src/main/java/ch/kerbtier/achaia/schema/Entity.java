package ch.kerbtier.achaia.schema;

import ch.kerbtier.achaia.Types;

public interface Entity {
  boolean is(Class<?> type);
  
  boolean is(Types type);

  Entity getParent();

  Types getType();
  
  /*
   * name is full path of model with list slot written as _, comma delimited
   */
  String getName();
}
