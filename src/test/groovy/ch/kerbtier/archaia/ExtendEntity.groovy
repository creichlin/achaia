package ch.kerbtier.archaia;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Test;

import ch.kerbtier.achaia.Parse;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.StringEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;

public class ExtendEntity {
  
  private MapEntity root
  private String modelPath = "src/test/resources"
  
  @Test()
  public void checkNewAttribute() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get(modelPath, "post.model"))
    Parse.extend(root, Paths.get(modelPath, "post.extend.model"))

    assertTrue(root.getObject("post").get("title2") instanceof StringEntity)
  }

  @Test()
  public void checkOldAttribute() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get(modelPath, "post.model"))
    Parse.extend(root, Paths.get(modelPath, "post.extend.model"))

    assertTrue(root.getObject("post").get("title") instanceof StringEntity)
  }

  @Test()
  public void checkNewAttributeInList() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get(modelPath, "post.model"))
    Parse.extend(root, Paths.get(modelPath, "post.extend.model"))

    assertTrue(root.getObject("post").getList("comments").getObject().get("name2") instanceof StringEntity)
  }

  @Test()
  public void checkOldAttributeInList() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get(modelPath, "post.model"))
    Parse.extend(root, Paths.get(modelPath, "post.extend.model"))

    assertTrue(root.getObject("post").getList("comments").getObject().get("name") instanceof StringEntity)
  }
}

