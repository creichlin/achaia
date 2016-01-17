package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.IntegerEntity;

public class ImpIntegerEntity extends ImpEntity implements IntegerEntity {

  public ImpIntegerEntity(Entity parent, String path) {
    super(parent, path);
  }

  @Override
  public Type getType() {
    return Type.INTEGER;
  }
}
