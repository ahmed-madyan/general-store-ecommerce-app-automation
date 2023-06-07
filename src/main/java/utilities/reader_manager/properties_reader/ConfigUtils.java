package utilities.reader_manager.properties_reader;

public class ConfigUtils {
    private static String baseURI_ST;
    private static String baseURI_SIT;
    private static String fireBase_URI;
    private static String fireBase_API_Key;
    private static String execution_Platform;
    private static String targetRemoteExecution;

    public static void setConfigProperties() {
//        setBaseURI_ST(PropertiesDataManager.getProperty("URI_ST", EXECUTION_CONFIG_FILE_PATH));
//        setBaseURI_SIT(PropertiesDataManager.getProperty("URI_SIT", EXECUTION_CONFIG_FILE_PATH));
//        setFireBase_URI(PropertiesDataManager.getProperty("FireBase_URI", EXECUTION_CONFIG_FILE_PATH));
//        setFireBase_API_Key(PropertiesDataManager.getProperty("FireBase_API_Key", EXECUTION_CONFIG_FILE_PATH));
        setExecution_Platform(PropertiesDataManager.getProperty("executionPlatform", PropertiesDataManager.Capability.EXECUTION_CAPABILITIES));
        setTargetRemoteExecution(PropertiesDataManager.getProperty("targetRemoteExecution", PropertiesDataManager.Capability.EXECUTION_CAPABILITIES));
    }

    public static void getCapability(String capability, String filePath) {
        PropertiesDataManager.getProperty(capability, filePath);
    }

    public static String getBaseURI_ST() {
        return baseURI_ST;
    }

    private static void setBaseURI_ST(String baseURI_ST) {
        ConfigUtils.baseURI_ST = baseURI_ST;
    }

    public static String getBaseURI_SIT() {
        return baseURI_SIT;
    }

    private static void setBaseURI_SIT(String baseURI_SIT) {
        ConfigUtils.baseURI_SIT = baseURI_SIT;
    }

    public static String getFireBase_URI() {
        return fireBase_URI;
    }

    public static void setFireBase_URI(String fireBase_URI) {
        ConfigUtils.fireBase_URI = fireBase_URI;
    }

    public static String getFireBase_API_Key() {
        return fireBase_API_Key;
    }

    public static void setFireBase_API_Key(String fireBase_API_Key) {
        ConfigUtils.fireBase_API_Key = fireBase_API_Key;
    }

    public static String getExecution_Platform() {
        return execution_Platform;
    }

    public static void setExecution_Platform(String execution_Platform) {
        ConfigUtils.execution_Platform = execution_Platform;
    }

    public static String getTargetRemoteExecution() {
        return targetRemoteExecution;
    }

    public static void setTargetRemoteExecution(String targetRemoteExecution) {
        ConfigUtils.targetRemoteExecution = targetRemoteExecution;
    }
}