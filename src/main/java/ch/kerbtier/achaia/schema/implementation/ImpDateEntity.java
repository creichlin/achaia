package ch.kerbtier.achaia.schema.implementation;


import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.DateEntity;
import ch.kerbtier.achaia.schema.Entity;

public class ImpDateEntity extends ImpEntity implements DateEntity {

  public ImpDateEntity(Entity parent, String path) {
    super(parent, path);
  }

  @Override
  public Type getType() {
    return Type.DATE;
  }

}
