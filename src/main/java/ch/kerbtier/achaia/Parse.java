package ch.kerbtier.achaia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Path;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;
import ch.kerbtier.achaia.schema.parser.AchaiaLexer;
import ch.kerbtier.achaia.schema.parser.AchaiaParser;
import ch.kerbtier.achaia.schema.parser.AchaiaParser.RootContext;
import ch.kerbtier.achaia.schema.parser.ImpVisitor;

public class Parse {
  
  public static void extend(MapEntity root, Path path) {
    try {
      extend(root, new FileInputStream(path.toFile()));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static void extend(MapEntity root, InputStream in) {
    extend(root, in, null);
  }

  public static void extend(MapEntity root, InputStream in, Charset charset) {
    Reader reader = new InputStreamReader(in, charset == null ? Charset.defaultCharset() : charset);
    extend(root, reader);
  }
  
  public static void extend(MapEntity root, Reader reader) {
    try {
      ANTLRInputStream input = new ANTLRInputStream(reader);

      AchaiaLexer lexer = new AchaiaLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      AchaiaParser parser = new AchaiaParser(tokens);
      parser.setErrorHandler(new BailErrorStrategy());

      RootContext tree = parser.root();

      reader.close();

      ImpVisitor iv = new ImpVisitor((ImpMapEntity)root);
      tree.accept(iv);
    } catch (ParseCancellationException e) {
      throw new ModelParseException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
