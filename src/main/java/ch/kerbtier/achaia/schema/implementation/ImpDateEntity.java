package ch.kerbtier.achaia.schema.implementation;


import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.DateEntity;
import ch.kerbtier.achaia.schema.Entity;

public class ImpDateEntity extends ImpEntity implements DateEntity {

  public ImpDateEntity(Entity parent, String name) {
    super(parent, name);
  }

  @Override
  public Types getType() {
    return Types.DATE;
  }

}
