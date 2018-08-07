package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/7/10.
 *
 * @author 37075
 * @date 2018/7/10
 * @time 16:12
 * @tool intellij idea
 */
public interface CheckExistsService {

    boolean checkExistsByExample(Object example);

    boolean checkExistsByPk(Object pk);

}
