package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.IntegerEntity;

public class ImpIntegerEntity extends ImpEntity implements IntegerEntity {

  public ImpIntegerEntity(Entity parent, String name) {
    super(parent, name);
  }

  @Override
  public Types getType() {
    return Types.INTEGER;
  }
}
