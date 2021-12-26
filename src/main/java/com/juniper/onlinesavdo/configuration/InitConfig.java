package com.juniper.onlinesavdo.configuration;

import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class InitConfig {

    public static boolean isStart() {
        Properties props = new Properties();
        try {
            props.load(new ClassPathResource("/application.yml").getInputStream());
            if (props.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")) {
                return true;
            } else {
//                String confirm = JOptionPane.showInputDialog("Ma'lumotlarni o'chirib yuborma! Keyin bilmay qoldim dema! Agar rostdan ham o'chirmoqchi bo'lsang. O'chirish kodi (HILOL TECHDAN SURA) :");
//                if (confirm != null && confirm.equals("ORDER_BOT_DELETE")) {
                    return true;
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
