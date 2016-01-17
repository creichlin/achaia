package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.SlugEntity;

public class ImpSlugEntity extends ImpEntity implements SlugEntity {

  public ImpSlugEntity(Entity parent, String path) {
    super(parent, path);
  }

  @Override
  public Type getType() {
    return Type.SLUG;
  }
}
