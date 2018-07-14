package com.utils.scp.engine;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;

import java.util.logging.Logger;

public class FileTransferUtils {

    private JSch jsch;
    private String host;
    private String username;
    private String password;

    private static final Logger logger = Logger.getLogger(FileTransferUtils.class.getName());

    public FileTransferUtils(JSch jsch, String host, String username, String password) {
        this.jsch = jsch;
        this.host = host;
        this.username = username;
        this.password = password;
    }

    public void transferFile(String source, String target) throws Exception {

        Session session = null;
        ChannelSftp sftpChannel = null;

        try {
            session = jsch.getSession(username, host);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            SftpATTRS attrs = null;

            try {
                attrs = sftpChannel.stat(target);
            } catch (Exception e) {
                logger.info(target + " directory not found");
            }

            if (attrs == null) {
                logger.info("creating directory " + target);
                sftpChannel.mkdir(target);
            }

            sftpChannel.put(source, target);

        } finally {

            if (sftpChannel != null) {
                sftpChannel.exit();
                sftpChannel.disconnect();
            }

            if (session != null) {
                session.disconnect();
            }

        }

        logger.info("Successfully transferred file from " + source + " to " + host + ":" + target);
    }


}
