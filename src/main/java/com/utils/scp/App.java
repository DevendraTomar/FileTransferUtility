package com.utils.scp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.scp.config.FileTransferConfig;
import com.utils.scp.service.FileTransferService;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());


    public static String readDataFromIs(InputStream is) throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];

        int length;

        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString("UTF-8");
    }


    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream is = new FileInputStream("./conf/config.json");

        String configJsonValue = readDataFromIs(is);

        FileTransferConfig config = objectMapper.readValue(configJsonValue, FileTransferConfig.class);

        FileTransferService service = new FileTransferService();

        logger.info("Initiating Job for : " + args[0]);

        if (args[0].equals("dev")) {
            List<FileTransferConfig.Config> configs = config.getDev();
            service.execute(configs);
        } else {
            List<FileTransferConfig.Config> configs = config.getQa();
            service.execute(configs);
        }

    }

}
