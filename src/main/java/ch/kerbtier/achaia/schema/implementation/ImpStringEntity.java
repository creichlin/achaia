package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.StringEntity;

public class ImpStringEntity extends ImpEntity implements StringEntity {

  public ImpStringEntity(Entity parent, String path) {
    super(parent, path);
  }

  @Override
  public Type getType() {
    return Type.STRING;
  }
}
