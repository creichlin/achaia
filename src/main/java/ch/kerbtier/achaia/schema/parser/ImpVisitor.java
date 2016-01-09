package ch.kerbtier.achaia.schema.parser;

import java.util.List;
import java.util.Stack;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.ListEntity;
import ch.kerbtier.achaia.schema.InvalidFieldException;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.UndefinedFieldException;
import ch.kerbtier.achaia.schema.implementation.ImpBinaryEntity;
import ch.kerbtier.achaia.schema.implementation.ImpDateEntity;
import ch.kerbtier.achaia.schema.implementation.ImpEntity;
import ch.kerbtier.achaia.schema.implementation.ImpListEntity;
import ch.kerbtier.achaia.schema.implementation.ImpIntegerEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;
import ch.kerbtier.achaia.schema.implementation.ImpSlugEntity;
import ch.kerbtier.achaia.schema.implementation.ImpStringEntity;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.BlobContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.DateContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.EntityContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.IntegerContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.ListContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.MapContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.RootContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.SlugContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.StringContext;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.UserContext;

import com.google.common.base.Joiner;

public class ImpVisitor extends AchaiaBaseVisitor<ImpEntity> {

  private Stack<ImpEntity> parents = new Stack<>();
  private Stack<String> names = new Stack<>();

  private ImpMapEntity root;

  public ImpVisitor(ImpMapEntity root) {
    this.root = root;
    parents.push(root);
  }

  private String getName() {
    return Joiner.on(".").join(names);
  }

  @Override
  public ImpEntity visitRoot(RootContext ctx) {
    populateEntity(ctx.entity(), root);
    return root;
  }

  @Override
  public ImpEntity visitDate(DateContext ctx) {
    return new ImpDateEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitString(StringContext ctx) {
    return new ImpStringEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitInteger(IntegerContext ctx) {
    return new ImpIntegerEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitBlob(BlobContext ctx) {
    return new ImpBinaryEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitList(ListContext ctx) {
    ImpListEntity list = null;

    try {
      if (parents.peek().is(Types.MAP)) {
        list = (ImpListEntity) ((MapEntity) parents.peek()).getList(names.peek());
      } else {
        throw new AssertionError();
      }
    } catch (UndefinedFieldException e) {
      // will be populated later
    }

    if (list == null) {
      list = new ImpListEntity(parents.peek(), getName());
    }

    names.push("_");
    parents.push(list);
    list.setType(ctx.type().accept(this));
    parents.pop();
    names.pop();

    return list;
  }

  @Override
  public ImpEntity visitUser(UserContext ctx) {
    throw new RuntimeException();
    // return new ImpUserEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitSlug(SlugContext ctx) {
    return new ImpSlugEntity(parents.peek(), getName());
  }

  @Override
  public ImpEntity visitMap(MapContext ctx) {
    ImpMapEntity map = null;

    try {
      if (parents.peek().is(Types.MAP)) {
        map = (ImpMapEntity) ((MapEntity) parents.peek()).getObject(names.peek());
      } else if (parents.peek().is(Types.LIST)) {
        map = (ImpMapEntity) ((ListEntity) parents.peek()).getObject();
      }
    } catch (UndefinedFieldException e) {
      // will be populated later
    }

    if (map == null) {
      map = new ImpMapEntity(parents.peek(), getName());
    }

    parents.push(map);
    populateEntity(ctx.entity(), map);
    parents.pop();

    return map;
  }

  private void populateEntity(List<EntityContext> list, ImpMapEntity map) {
    for (EntityContext ec : list) {
      String key = ec.identifier().getText();
      names.push(key);
      ImpEntity type = ec.type().accept(this);
      names.pop();
      map.put(key, type);
    }
  }
}
