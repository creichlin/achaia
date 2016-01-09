package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.BinaryEntity;
import ch.kerbtier.achaia.schema.Entity;

public class ImpBinaryEntity extends ImpEntity implements BinaryEntity {

  public ImpBinaryEntity(Entity parent, String name) {
    super(parent, name);
  }

  @Override
  public Types getType() {
    return Types.BINARY;
  }

}
