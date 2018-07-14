package com.utils.scp.config;

import java.io.Serializable;
import java.util.List;

public class FileTransferConfig implements Serializable {

    private List<Config> dev;
    private List<Config> qa;

    public List<Config> getDev() {
        return dev;
    }

    public void setDev(List<Config> dev) {
        this.dev = dev;
    }

    public List<Config> getQa() {
        return qa;
    }

    public void setQa(List<Config> qa) {
        this.qa = qa;
    }

    public static class Config implements Serializable {

        private String hostname;
        private String username;
        private String password;
        private String target_dir;
        private List<SourceConfig> files;

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTarget_dir() {
            return target_dir;
        }

        public void setTarget_dir(String target_dir) {
            this.target_dir = target_dir;
        }

        public List<SourceConfig> getFiles() {
            return files;
        }

        public void setFiles(List<SourceConfig> files) {
            this.files = files;
        }

        public static class SourceConfig implements Serializable {

            private String source_file;

            public String getSource_file() {
                return source_file;
            }

            public void setSource_file(String source_file) {
                this.source_file = source_file;
            }

            @Override
            public String toString() {
                return "SourceConfig{" +
                        "source_file='" + source_file + '\'' +
                        '}';
            }

        }

        @Override
        public String toString() {
            return "Config{" +
                    "hostname='" + hostname + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", target_dir='" + target_dir + '\'' +
                    ", files=" + files +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "FileTransferConfig{" +
                "dev=" + dev +
                ", qa=" + qa +
                '}';
    }

}