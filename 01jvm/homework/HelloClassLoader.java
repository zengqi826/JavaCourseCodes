package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Zeng Qi
 * @description classloader demo
 * @date 2021/1/7 22:18
 */
public class HelloClassLoader extends ClassLoader {
  private static String FILE_NAME = "F:\\github\\JavaCourseCodes\\01jvm\\homework\\Hello.xlass";

  public static void main(String[] args) {
    try {
      Class<?> clazz = new HelloClassLoader().findClass("Hello");
      Method declaredMethod = clazz.getDeclaredMethod("hello");
      declaredMethod.invoke(clazz.newInstance());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    File file = new File(FILE_NAME);
    byte[] bytes = null;
    try {
      InputStream inputStream = new FileInputStream(file);
      bytes = getDecodeBytes(inputStream);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return defineClass(name, bytes, 0, bytes.length);
  }

  private byte[] getDecodeBytes(InputStream inputStream) throws IOException {
    byte[] srcBytes = new byte[inputStream.available()];
    inputStream.read(srcBytes);
    byte[] bytes = new byte[srcBytes.length];
    for (int i = 0; i < srcBytes.length; i++) {
      bytes[i] = (byte) (255 - srcBytes[i]);
    }
    return bytes;
  }
}
