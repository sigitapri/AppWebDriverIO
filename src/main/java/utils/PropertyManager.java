package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties props = new Properties();

    public Properties getPropsProduction() throws IOException {
        InputStream is = null;
        String propsFileName = "Data/application-Production.properties";
        if(props.isEmpty()){
            try{
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                System.out.println("Failed to load config properties. ABORT!!");
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
    public Properties getPropsDefel() throws IOException {
        InputStream is = null;
        String propsFileName = "Data/application-Defel.properties";
        if(props.isEmpty()){
            try{
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                System.out.println("Failed to load config properties. ABORT!!");
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
    public Properties getPropsDemo() throws IOException {
        InputStream is = null;
        String propsFileName = "Data/application-Demo.properties";
        if(props.isEmpty()){
            try{
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                System.out.println("Failed to load config properties. ABORT!!");
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
}
