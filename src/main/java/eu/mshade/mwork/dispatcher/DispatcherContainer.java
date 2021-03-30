package eu.mshade.mwork.dispatcher;

public interface DispatcherContainer {

    <T> T getContainer(Class<T> aClass);

    <T> T getContainer(String key, Class<T> aClass);

    static DispatcherContainer empty(){
        return DispatcherContainerBuilder.builder().build();
    }
}
