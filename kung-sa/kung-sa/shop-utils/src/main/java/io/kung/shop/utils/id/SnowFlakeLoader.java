package io.kung.shop.utils.id;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author kung
 * @Date 2023/2/22 15:18
 * @Version 1.0.0
 * @Description 定义加载params.properties文件的工具类
 */
public class SnowFlakeLoader {

    public static final String DATA_CENTER_ID = "data.center.id";
    public static final String MACHINE_ID = "machine.id";

    private volatile static Properties instance;

    static {
        InputStream in = SnowFlakeLoader.class.getClassLoader().getResourceAsStream("snowflake/snowflake.properties");
        instance = new Properties();
        try {
            instance.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringValue(String key) {
        if (instance == null) return "";
        return instance.getProperty(key, "");
    }

    private static Long getLongValue(String key) {
        String v = getStringValue(key);
        return (v == null || v.trim().isEmpty()) ? 0 : Long.parseLong(v);
    }

    public static Long getDataCenterId() {
        return getLongValue(DATA_CENTER_ID);
    }

    public static Long getMachineId() {
        return getLongValue(MACHINE_ID);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(getDataCenterId());
        System.out.println(getMachineId());
        System.out.println(Long.MAX_VALUE);
        System.out.println(SnowFlakeFactory.getSnowFlakeByDataCenterIdAndMachineIdFromCache(SnowFlakeLoader.getDataCenterId(), SnowFlakeLoader.getMachineId()).nextId());
        System.out.println(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
    }
}
