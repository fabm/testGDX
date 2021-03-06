package pt.ipg.mcm.salta.blocos.desktop;

import pt.ipg.mcm.salta.blocos.main.Provider;
import org.mockito.Mockito;

public class MockProvider<T> implements Provider<T>{
  private T mock;

  public MockProvider(Class<T> cl) {
    this.mock = Mockito.mock(cl);
  }

  @Override
  public T get() {
    return mock;
  }
}
