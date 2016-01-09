package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.SlugEntity;

public class ImpSlugEntity extends ImpEntity implements SlugEntity {

  public ImpSlugEntity(Entity parent, String name) {
    super(parent, name);
  }

  @Override
  public Types getType() {
    return Types.SLUG;
  }
}
