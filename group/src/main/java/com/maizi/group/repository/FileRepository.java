package com.maizi.group.repository;

import com.maizi.group.domain.File;

public interface FileRepository {

    void save(File file);

    File get(String uuid);
}
