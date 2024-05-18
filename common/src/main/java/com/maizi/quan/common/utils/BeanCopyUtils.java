package com.maizi.quan.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BeanCopyUtils {

    public static <T> T to(Object source, Class<T> targetC) {
        T target = null;
        try {
            target = targetC.newInstance();
        } catch (Exception e) {
        }

        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List<T> toList(List source, Class<T> targetC) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.EMPTY_LIST;
        }
        List<T> result = new ArrayList<>(source.size());
        for (Object o: source) {
            result.add(to(o, targetC));
        }
        return result;
    }
}
