package com.maizi.quan.manager;

import com.maizi.quan.manager.domain.File;

public interface FileRepository {

    void save(File file);

    File get(String uuid);
}
