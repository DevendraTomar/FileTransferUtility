package com.utils.scp.service;

import com.utils.scp.config.FileTransferConfig;

import java.util.List;

public interface Service {
    void execute(List<FileTransferConfig.Config> configs) throws Exception;
}
