package com.utils.scp.service;

import com.jcraft.jsch.JSch;
import com.utils.scp.config.FileTransferConfig;
import com.utils.scp.engine.FileTransferUtils;

import java.util.List;

public class FileTransferService implements Service {

    private JSch jsch = new JSch();

    @Override
    public void execute(List<FileTransferConfig.Config> configs) throws Exception {

        for (FileTransferConfig.Config config : configs) {

            FileTransferUtils engine = new FileTransferUtils(jsch, config.getHostname(), config.getUsername(), config.getPassword());

            List<FileTransferConfig.Config.SourceConfig> files = config.getFiles();

            String target = config.getTarget_dir();

            for (FileTransferConfig.Config.SourceConfig file : files) {

                String source = file.getSource_file();

                if (source.trim().isEmpty()) {
                    continue;
                }

                engine.transferFile(source, target);
            }

        }

    }

}
