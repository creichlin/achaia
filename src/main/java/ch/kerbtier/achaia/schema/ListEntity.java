package ch.kerbtier.achaia.schema;

public interface ListEntity extends Entity {
  Entity get();
  MapEntity getObject();
  ListEntity getList();
}
