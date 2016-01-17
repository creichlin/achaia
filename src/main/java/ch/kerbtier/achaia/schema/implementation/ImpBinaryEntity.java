package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.BinaryEntity;
import ch.kerbtier.achaia.schema.Entity;

public class ImpBinaryEntity extends ImpEntity implements BinaryEntity {

  public ImpBinaryEntity(Entity parent, String path) {
    super(parent, path);
  }

  @Override
  public Type getType() {
    return Type.BINARY;
  }

}
