package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.StringEntity;

public class ImpStringEntity extends ImpEntity implements StringEntity {

  public ImpStringEntity(Entity parent, String name) {
    super(parent, name);
  }

  @Override
  public Types getType() {
    return Types.STRING;
  }
}
